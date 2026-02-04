package me.Flayvor.CadastroSupremo.Missoes.Services;

import me.Flayvor.CadastroSupremo.Missoes.Models.MissaoSuprema;
import me.Flayvor.CadastroSupremo.Missoes.Repository.MissaoSupremaRepository;
import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;
import me.Flayvor.CadastroSupremo.Supremos.Repository.Supremosrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MissaoSupremaService {

    @Autowired
    private MissaoSupremaRepository missaoRepository;

    @Autowired
    private Supremosrepository supremoRepository;

    public List<MissaoSuprema> listarTodas() {
        return missaoRepository.findAll();
    }

    public MissaoSuprema buscarPorId(Long missaoId) {
        return missaoRepository.findById(missaoId)
                .orElseThrow(() -> new IllegalArgumentException("Missão com ID " + missaoId + " não encontrada."));
    }

    public MissaoSuprema salvar(MissaoSuprema missao) {
        return missaoRepository.save(missao);
    }

    @Transactional
    public MissaoSuprema atualizarMissao(Long missaoId, MissaoSuprema missaoAtualizada) {
        MissaoSuprema missaoExistente = buscarPorId(missaoId);

        missaoExistente.setDescricao(missaoAtualizada.getDescricao());
        missaoExistente.setDificuldade(missaoAtualizada.getDificuldade());
        missaoExistente.setRecompensa(missaoAtualizada.getRecompensa());

        return missaoRepository.save(missaoExistente);
    }

    @Transactional
    public MissaoSuprema atribuirSupremosAUmaMissao(Long missaoId, List<Long> supremoIds) {
        MissaoSuprema missao = buscarPorId(missaoId);
        List<SupremeModel> supremos = supremoRepository.findAllById(supremoIds);
        if (supremos.size() != supremoIds.size()) {
            throw new IllegalArgumentException("Um ou mais IDs de supremos não foram encontrados.");
        }

        for (SupremeModel supremo : supremos) {
            if (!supremo.getMissoes().contains(missao)) {
                supremo.getMissoes().add(missao);
            }
        }

        supremoRepository.saveAll(supremos);
        return missaoRepository.findById(missaoId).get();
    }

    @Transactional
    public MissaoSuprema desatribuirSupremos(Long missaoId, List<Long> supremoIds) {
        MissaoSuprema missao = buscarPorId(missaoId);
        List<SupremeModel> supremos = supremoRepository.findAllById(supremoIds);
        if (supremos.size() != supremoIds.size()) {
            throw new IllegalArgumentException("Um ou mais IDs de supremos não foram encontrados.");
        }

        for (SupremeModel supremo : supremos) {
            supremo.getMissoes().remove(missao);
        }

        supremoRepository.saveAll(supremos);
        return missaoRepository.findById(missaoId).get();
    }

    @Transactional
    public void deletarMissao(Long missaoId) {
        MissaoSuprema missao = buscarPorId(missaoId);
        for (SupremeModel supremo : missao.getSupremos()) {
            supremo.getMissoes().remove(missao);
        }
        missaoRepository.delete(missao);
    }
}

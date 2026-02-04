package me.Flayvor.CadastroSupremo.Supremos.Services;

import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;
import me.Flayvor.CadastroSupremo.Supremos.Repository.Supremosrepository;
import me.Flayvor.CadastroSupremo.Supremos.dtos.LoginRequestDTO;
import me.Flayvor.CadastroSupremo.Supremos.dtos.LoginResponseDTO;
import me.Flayvor.CadastroSupremo.config.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupremoService {

    @Autowired
    private Supremosrepository supremosrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<SupremeModel> listarSupremos() {
        return supremosrepository.findAll();
    }

    public SupremeModel buscarPorId(Long supremoId) {
        return supremosrepository.findById(supremoId)
                .orElseThrow(() -> new IllegalArgumentException("Supremo com ID " + supremoId + " não encontrado."));
    }

    @Transactional
    public SupremeModel salvar(SupremeModel supremo) {
        Optional<SupremeModel> supremoExistente = supremosrepository.findByEmail(supremo.getEmail());
        if (supremoExistente.isPresent() && !supremoExistente.get().getId().equals(supremo.getId())) {
            throw new IllegalStateException("E-mail já cadastrado.");
        }

        String senhaCriptografada = passwordEncoder.encode(supremo.getSenha());
        supremo.setSenha(senhaCriptografada);

        return supremosrepository.save(supremo);
    }

    @Transactional
    public SupremeModel atualizarSupremo(Long supremoId, SupremeModel supremoAtualizado) {
        SupremeModel supremoExistente = buscarPorId(supremoId);

        // Valida se o novo e-mail já não está em uso por outro supremo
        Optional<SupremeModel> outroSupremoComMesmoEmail = supremosrepository.findByEmail(supremoAtualizado.getEmail());
        if (outroSupremoComMesmoEmail.isPresent() && !outroSupremoComMesmoEmail.get().getId().equals(supremoId)) {
            throw new IllegalStateException("E-mail já cadastrado para outro supremo.");
        }

        // Atualiza os dados
        supremoExistente.setNome(supremoAtualizado.getNome());
        supremoExistente.setEmail(supremoAtualizado.getEmail());
        supremoExistente.setPoder(supremoAtualizado.getPoder());

        // Se uma nova senha foi fornecida (não nula ou vazia), criptografa e atualiza.
        if (supremoAtualizado.getSenha() != null && !supremoAtualizado.getSenha().isEmpty()) {
            supremoExistente.setSenha(passwordEncoder.encode(supremoAtualizado.getSenha()));
        }

        return supremosrepository.save(supremoExistente);
    }

    public LoginResponseDTO autenticar(LoginRequestDTO loginRequest) {
        SupremeModel supremo = supremosrepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new AuthenticationException("E-mail ou senha inválidos."));

        if (!passwordEncoder.matches(loginRequest.getSenha(), supremo.getSenha())) {
            throw new AuthenticationException("E-mail ou senha inválidos.");
        }

        return new LoginResponseDTO("Login bem-sucedido! Bem-vindo(a), " + supremo.getNome() + ".");
    }

    public void deletarSupremo(Long supremoId) {
        supremosrepository.deleteById(supremoId);
    }
}

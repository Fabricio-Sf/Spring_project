//package me.Flayvor.CadastroSupremo.Missoes.Services;
//
//import me.Flayvor.CadastroSupremo.Missoes.Models.missoesSupremas;
//import me.Flayvor.CadastroSupremo.Missoes.Repository.MissoesSupremasRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MissoesService {
//
//    @Autowired
//    private MissoesSupremasRepository missoesRepository;
//
//    public List<missoesSupremas> listarTodas() {
//        return missoesRepository.findAll();
//    }
//
//    public missoesSupremas salvar(missoesSupremas missao) {
//        // Aqui você pode adicionar regras de negócio antes de salvar uma missão.
//        return missoesRepository.save(missao);
//    }
//}

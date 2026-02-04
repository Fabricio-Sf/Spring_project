package me.Flayvor.CadastroSupremo.Missoes.Controller;

import me.Flayvor.CadastroSupremo.Missoes.Models.MissaoSuprema;
import me.Flayvor.CadastroSupremo.Missoes.Services.MissaoSupremaService;
import me.Flayvor.CadastroSupremo.Missoes.dtos.AtribuirSupremosRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoSupremaController {

    @Autowired
    private MissaoSupremaService missaoService;

    @GetMapping
    public ResponseEntity<List<MissaoSuprema>> listarTodas() {
        List<MissaoSuprema> missoes = missaoService.listarTodas();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/{missaoId}")
    public ResponseEntity<MissaoSuprema> buscarPorId(@PathVariable Long missaoId) {
        MissaoSuprema missao = missaoService.buscarPorId(missaoId);
        return ResponseEntity.ok(missao);
    }

    @PostMapping
    public ResponseEntity<MissaoSuprema> criarMissao(@RequestBody MissaoSuprema missao) {
        missao.setSupremos(null);
        MissaoSuprema novaMissao = missaoService.salvar(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    @PutMapping("/{missaoId}")
    public ResponseEntity<MissaoSuprema> atualizarMissao(@PathVariable Long missaoId, @RequestBody MissaoSuprema missaoAtualizada) {
        MissaoSuprema missao = missaoService.atualizarMissao(missaoId, missaoAtualizada);
        return ResponseEntity.ok(missao);
    }

    @PostMapping("/{missaoId}/atribuir-supremos")
    public ResponseEntity<MissaoSuprema> atribuirSupremos(
            @PathVariable Long missaoId,
            @RequestBody AtribuirSupremosRequestDTO request) {

        MissaoSuprema missaoAtualizada = missaoService.atribuirSupremosAUmaMissao(missaoId, request.getSupremoIds());
        return ResponseEntity.ok(missaoAtualizada);
    }

    @PostMapping("/{missaoId}/desatribuir-supremos")
    public ResponseEntity<MissaoSuprema> desatribuirSupremos(
            @PathVariable Long missaoId,
            @RequestBody AtribuirSupremosRequestDTO request) {

        MissaoSuprema missaoAtualizada = missaoService.desatribuirSupremos(missaoId, request.getSupremoIds());
        return ResponseEntity.ok(missaoAtualizada);
    }

    @DeleteMapping("/{missaoId}")
    public ResponseEntity<Void> deletarMissao(@PathVariable Long missaoId) {
        missaoService.deletarMissao(missaoId);
        return ResponseEntity.noContent().build();
    }
}

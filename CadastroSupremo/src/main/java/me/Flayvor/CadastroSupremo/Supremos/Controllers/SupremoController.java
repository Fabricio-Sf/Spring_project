package me.Flayvor.CadastroSupremo.Supremos.Controllers;

import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;
import me.Flayvor.CadastroSupremo.Supremos.Services.SupremoService;
import me.Flayvor.CadastroSupremo.Supremos.dtos.LoginRequestDTO;
import me.Flayvor.CadastroSupremo.Supremos.dtos.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supremos")
public class SupremoController {

    @Autowired
    private SupremoService supremoService;

    @GetMapping
    public List<SupremeModel> listar() {
        return supremoService.listarSupremos();
    }

    @GetMapping("/{supremoId}")
    public ResponseEntity<SupremeModel> buscarPorId(@PathVariable Long supremoId) {
        SupremeModel supremo = supremoService.buscarPorId(supremoId);
        return ResponseEntity.ok(supremo);
    }

    @PostMapping
    public ResponseEntity<SupremeModel> cadastrar(@RequestBody SupremeModel supremo) {
        SupremeModel novoSupremo = supremoService.salvar(supremo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSupremo);
    }

    @PutMapping("/{supremoId}")
    public ResponseEntity<SupremeModel> atualizarSupremo(@PathVariable Long supremoId, @RequestBody SupremeModel supremoAtualizado) {
        SupremeModel supremo = supremoService.atualizarSupremo(supremoId, supremoAtualizado);
        return ResponseEntity.ok(supremo);
    }

    @DeleteMapping("/{supremoId}")
    public ResponseEntity<Void> deletarSupremo(@PathVariable Long supremoId) {
        supremoService.deletarSupremo(supremoId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = supremoService.autenticar(loginRequest);
        return ResponseEntity.ok(response);
    }
}

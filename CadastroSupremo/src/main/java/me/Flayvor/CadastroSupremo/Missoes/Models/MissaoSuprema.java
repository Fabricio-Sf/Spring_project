package me.Flayvor.CadastroSupremo.Missoes.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoSuprema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private int dificuldade;
    private int recompensa;

    @ManyToMany(mappedBy = "missoes")
    @JsonIgnoreProperties("missoes") // Evita recursão infinita no JSON
    private List<SupremeModel> supremos;
}

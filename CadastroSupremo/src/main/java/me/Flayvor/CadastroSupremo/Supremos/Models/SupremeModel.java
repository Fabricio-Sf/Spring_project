package me.Flayvor.CadastroSupremo.Supremos.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.Flayvor.CadastroSupremo.Missoes.Models.MissaoSuprema;

import java.util.List;

@Entity
@Table(name = "tb_supremos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupremeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private int poder;

    @Column(nullable = false)
    private String senha;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "tb_supremo_missoes",
            joinColumns = @JoinColumn(name = "supremo_id"),
            inverseJoinColumns = @JoinColumn(name = "missao_id")
    )
    @JsonIgnoreProperties("supremos") // Evita recursão infinita no JSON
    private List<MissaoSuprema> missoes;
}

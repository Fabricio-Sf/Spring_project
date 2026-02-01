package me.Flayvor.CadastroSupremo.Missoes.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;


@Entity
@Table(name = "tb_missoes_Supremas")
public class missoesSupremas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private int dificuldade;
    private int recompensa;

    private SupremeModel supreme;

    @OneToMany(mappedBy = "missoes")
    private List<SupremeModel> supremos;


    public missoesSupremas() {
    }

    public missoesSupremas(String descricao, int dificuldade, int recompensa) {
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.recompensa = recompensa;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getRecompensa() {
        return recompensa;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
}

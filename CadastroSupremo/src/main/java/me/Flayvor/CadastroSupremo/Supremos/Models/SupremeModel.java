package me.Flayvor.CadastroSupremo.Supremos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import java.util.List;
import me.Flayvor.CadastroSupremo.Missoes.Models.missoesSupremas;

@Entity
@Table(name = "tb_Cadastro_de_Supremos")
@Data // Lombok: Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor
@AllArgsConstructor
public class SupremeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int poder;
    private String senha; // ATENÇÃO: A senha não deve ser armazenada em texto puro.

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private missoesSupremas missoes;

}

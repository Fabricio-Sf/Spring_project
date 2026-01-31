package me.Flayvor.CadastroSupremo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tb_Cadastro_de_Supremos")
public class SupremeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private int poder;

    // Non-args constructor
    public SupremeModel() {
    }

    // All-args constructor
    public SupremeModel(String nome, String email, String senha, int poder) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.poder = poder;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getPoder() {
        return poder;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

}

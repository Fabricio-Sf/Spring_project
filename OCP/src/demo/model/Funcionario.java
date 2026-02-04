package demo.model;

public class Funcionario {
    private String nome;
    private static Cargo cargo;
    private double salarioBase;

    public Funcionario(String nome, Cargo cargo, double salarioBase) {
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public static Cargo getCargo() {
        return cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

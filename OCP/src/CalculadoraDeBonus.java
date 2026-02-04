import demo.model.Funcionario;

public class CalculadoraDeBonus {
    public double calculaBonus(Funcionario funcionario, RegraDeBonus regraDeBonus) {
       return regraDeBonus.aplicarBonus(funcionario.getSalarioBase());
    }

}

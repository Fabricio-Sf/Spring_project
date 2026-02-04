import demo.model.Cargo;
import demo.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

public class Main {

    @Autowired
    @Qualifier("funcionarioJoao")
    private static Funcionario gerente;

    @Autowired
    ApplicationContext context;

    @Qualifier("funcionarioJose")
    private static Funcionario jose;

    public static void main(String[] args) {
        Funcionario dev = new Funcionario("Maria", Cargo.DESENVOLVEDOR, 3000.0);
        Funcionario estagiario = new Funcionario("Pedro", Cargo.ESTAGIARIO, 1000.0);

        CalculadoraDeBonus calculadora = new CalculadoraDeBonus();

        RegraDeBonus BonusGerente = new BonusGerente(0.2);
        RegraDeBonus BonusDesenvolverdor = new BonusDesenvolverdor(0.1);
        RegraDeBonus BonusEstagiario = new BonusEstagiario(0.05);

        System.out.println("Bônus do Gerente: " + calculadora.calculaBonus(gerente, BonusGerente));
        System.out.println("Bônus do Desenvolvedor: " + calculadora.calculaBonus(dev, BonusDesenvolverdor));
        System.out.println("Bônus do Estagiário: " + calculadora.calculaBonus(estagiario, BonusEstagiario));
    }
}

public class BonusEstagiario implements RegraDeBonus{

    private double bonus;

    public BonusEstagiario(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double aplicarBonus(double salarioBase) {
        return salarioBase * bonus;
    }
}


public class BonusDesenvolverdor implements RegraDeBonus {
    private double bonus;

    public BonusDesenvolverdor(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double aplicarBonus(double salarioBase) {
        return salarioBase * bonus;
    }
}


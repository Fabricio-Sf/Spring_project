public class BonusGerente implements RegraDeBonus{
    private double bonus;

    public BonusGerente(double bonus){
        this.bonus = bonus;
    }

    @Override
    public double aplicarBonus(double salarioBase){
        return salarioBase * bonus;

    }
}

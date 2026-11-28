public class YuzdeIndirim implements IIndirimPolitikasi {
    private static final double ORAN = 0.20;

    @Override
    public double Uygula(double tutar) {
        return tutar * (1 - ORAN);
    }

    @Override
    public String toString() {
        return "YuzdeIndirim(%20)";
    }
}
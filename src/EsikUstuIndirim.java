public class EsikUstuIndirim implements IIndirimPolitikasi {
    private static final double ESIK = 1500.0;
    private static final double ORAN = 0.20;

    @Override
    public double Uygula(double tutar) {
        if (tutar <= ESIK) {
            return tutar;
        }
        double asanKisim = tutar - ESIK;
        return ESIK + asanKisim * (1 - ORAN);
    }

    @Override
    public String toString() {
        return "EsikUstuIndirim(1500 TL ustune %20)";
    }
}
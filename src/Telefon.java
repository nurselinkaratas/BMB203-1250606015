public class Telefon extends Cihaz {
    private static final double KATSAYI = 0.75;
    private static final double EK_UCRET_ORANI = 0.20;
    private static final double EK_UCRET_ESIGI = 7;

    private double ekranInc;

    public Telefon(String seriNo, String marka, double ekranInc) {
        super(seriNo, marka);
        setEkranInc(ekranInc);
    }

    public double getEkranInc() { return ekranInc; }

    public void setEkranInc(double ekranInc) {
        if (ekranInc < 4 || ekranInc > 7)
            throw new IllegalArgumentException("Ekran inc 4-7 arasında olmalı: " + ekranInc);
        this.ekranInc = ekranInc;
    }

    public boolean ekUcretVarMi() {
        return ekranInc >= EK_UCRET_ESIGI;
    }

    @Override
    public double Hesapla(int saat) {
        double ucret = BIRIM_FIYAT * saat * KATSAYI;
        if (ekUcretVarMi()) {
            ucret = ucret * (1 + EK_UCRET_ORANI);
        }
        return ucret;
    }

    @Override
    public String toString() {
        return "Telefon{" + super.toString() + ", ekranInc=" + ekranInc + "}";
    }
}
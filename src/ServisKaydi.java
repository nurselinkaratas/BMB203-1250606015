public class ServisKaydi {
    private final Cihaz cihaz;
    private final int tahminiSaat;
    private boolean teslimEdildi;
    private double servisUcreti;

    public ServisKaydi(Cihaz cihaz, int tahminiSaat) {
        if (cihaz == null)
            throw new IllegalArgumentException("Cihaz boş olamaz");
        if (tahminiSaat <= 0)
            throw new IllegalArgumentException("Tahmini saat 0'dan büyük olmalı: " + tahminiSaat);
        this.cihaz = cihaz;
        this.tahminiSaat = tahminiSaat;
        this.teslimEdildi = false;
        this.servisUcreti = 0;
    }

    public Cihaz getCihaz() { return cihaz; }
    public int getTahminiSaat() { return tahminiSaat; }
    public boolean isTeslimEdildi() { return teslimEdildi; }
    public double getServisUcreti() { return servisUcreti; }

    public void teslimEt(double ucret) {
        this.servisUcreti = ucret;
        this.teslimEdildi = true;
    }

    @Override
    public String toString() {
        return cihaz + ", tahminiSaat=" + tahminiSaat
                + ", teslimEdildi=" + teslimEdildi
                + ", servisUcreti=" + servisUcreti;
    }
}
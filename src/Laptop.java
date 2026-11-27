public class Laptop extends Cihaz {
    private static final double KATSAYI = 1.25;

    private int ramGb;

    public Laptop(String seriNo, String marka, int ramGb) {
        super(seriNo, marka);
        setRamGb(ramGb);
    }

    public int getRamGb() { return ramGb; }

    public void setRamGb(int ramGb) {
        if (ramGb < 4 || ramGb > 64)
            throw new IllegalArgumentException("RAM 4-64 GB arasında olmalı: " + ramGb);
        this.ramGb = ramGb;
    }

    @Override
    public double Hesapla(int saat) {
        return BIRIM_FIYAT * saat * KATSAYI;
    }

    @Override
    public String toString() {
        return "Laptop{" + super.toString() + ", ramGb=" + ramGb + "}";
    }
}
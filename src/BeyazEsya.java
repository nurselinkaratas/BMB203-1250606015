public class BeyazEsya extends Cihaz {
    private static final double KATSAYI = 0.75;

    private int enerjiSinifi;

    public BeyazEsya(String seriNo, String marka, int enerjiSinifi) {
        super(seriNo, marka);
        setEnerjiSinifi(enerjiSinifi);
    }

    public int getEnerjiSinifi() { return enerjiSinifi; }

    public void setEnerjiSinifi(int enerjiSinifi) {
        if (enerjiSinifi < 1 || enerjiSinifi > 7)
            throw new IllegalArgumentException("Enerji sınıfı 1-7 arasında olmalı: " + enerjiSinifi);
        this.enerjiSinifi = enerjiSinifi;
    }

    @Override
    public double Hesapla(int saat) {
        return BIRIM_FIYAT * saat * KATSAYI;
    }

    @Override
    public String toString() {
        return "BeyazEsya{" + super.toString() + ", enerjiSinifi=" + enerjiSinifi + "}";
    }
}
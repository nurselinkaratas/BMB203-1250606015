public abstract class Cihaz {
    private static int sayac = 0;
    protected static final double BIRIM_FIYAT = 45.0;

    private final int id;
    private String seriNo;
    private String marka;

    public Cihaz(String seriNo, String marka) {
        this.id = ++sayac;
        setSeriNo(seriNo);
        setMarka(marka);
    }

    public int getId() { return id; }
    public String getSeriNo() { return seriNo; }
    public String getMarka() { return marka; }

    public void setSeriNo(String seriNo) {
        if (seriNo == null || seriNo.isBlank())
            throw new IllegalArgumentException("Seri no boş olamaz");
        this.seriNo = seriNo;
    }

    public void setMarka(String marka) {
        if (marka == null || marka.isBlank())
            throw new IllegalArgumentException("Marka boş olamaz");
        this.marka = marka;
    }

    public abstract double Hesapla(int saat);

    @Override
    public String toString() {
        return "Cihaz{id=" + id + ", seriNo=" + seriNo + ", marka=" + marka + "}";
    }
}
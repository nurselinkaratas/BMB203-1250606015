import java.util.ArrayList;
import java.util.List;

public class TeknikServis {
    private final int kapasite;
    private final List<ServisKaydi> kayitlar = new ArrayList<>();
    private IIndirimPolitikasi indirimPolitikasi;
        private static final int ONAY_ESIGI_SAAT = 5;

    public TeknikServis(int kapasite, IIndirimPolitikasi indirimPolitikasi) {
        if (kapasite <= 0)
            throw new IllegalArgumentException("Kapasite 0'dan büyük olmalı: " + kapasite);
        this.kapasite = kapasite;
        setIndirimPolitikasi(indirimPolitikasi);
    }

    public int getKapasite() { return kapasite; }

    public IIndirimPolitikasi getIndirimPolitikasi() { return indirimPolitikasi; }

    public void setIndirimPolitikasi(IIndirimPolitikasi indirimPolitikasi) {
        if (indirimPolitikasi == null)
            throw new IllegalArgumentException("İndirim politikası boş olamaz");
        this.indirimPolitikasi = indirimPolitikasi;
    }

    public int bekleyenSayisi() {
        int sayac = 0;
        for (ServisKaydi kayit : kayitlar) {
            if (!kayit.isTeslimEdildi()) {
                sayac++;
            }
        }
        return sayac;
    }

    public List<ServisKaydi> kayitlariListele() {
        return List.copyOf(kayitlar);
    }
        private ServisKaydi kayitBul(int cihazId) {
        for (ServisKaydi kayit : kayitlar) {
            if (kayit.getCihaz().getId() == cihazId) {
                return kayit;
            }
        }
        return null;
    }

    public void CihazKabul(Cihaz cihaz, int tahminiSaat, boolean musteriOnayi)
            throws CihazTeslimEdildiException, OnayGerekliException {
        if (cihaz == null)
            throw new IllegalArgumentException("Cihaz boş olamaz");

        ServisKaydi mevcut = kayitBul(cihaz.getId());
        if (mevcut != null && mevcut.isTeslimEdildi())
            throw new CihazTeslimEdildiException(
                    "Teslim edilmiş cihaza yeni işlem eklenemez. Cihaz id: " + cihaz.getId(),
                    cihaz.getId());
        if (mevcut != null)
            throw new IllegalStateException("Cihaz zaten serviste. Cihaz id: " + cihaz.getId());

        if (bekleyenSayisi() >= kapasite)
            throw new IllegalStateException("Servis kapasitesi dolu: " + kapasite);

        if (tahminiSaat > ONAY_ESIGI_SAAT && !musteriOnayi)
            throw new OnayGerekliException(
                    "Tahmini süre " + ONAY_ESIGI_SAAT + " saati aşıyor, müşteri onayı gerekli: "
                            + tahminiSaat + " saat",
                    tahminiSaat);

        kayitlar.add(new ServisKaydi(cihaz, tahminiSaat));
    }
        public double OnarimTamamla(int cihazId) throws CihazTeslimEdildiException {
        ServisKaydi kayit = kayitBul(cihazId);
        if (kayit == null)
            throw new IllegalArgumentException("Serviste böyle bir cihaz yok. Cihaz id: " + cihazId);
        if (kayit.isTeslimEdildi())
            throw new CihazTeslimEdildiException(
                    "Teslim edilmiş cihaza yeni işlem eklenemez. Cihaz id: " + cihazId,
                    cihazId);

        double hamUcret = kayit.getCihaz().Hesapla(kayit.getTahminiSaat());
        double ucret = indirimPolitikasi.Uygula(hamUcret);
        kayit.teslimEt(ucret);
        return ucret;
    }
}
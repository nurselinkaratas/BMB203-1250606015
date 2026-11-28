import java.util.ArrayList;
import java.util.List;

public class TeknikServis {
    private final int kapasite;
    private final List<ServisKaydi> kayitlar = new ArrayList<>();
    private IIndirimPolitikasi indirimPolitikasi;

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
}
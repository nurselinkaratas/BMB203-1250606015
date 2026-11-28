public class IndirimYok implements IIndirimPolitikasi {

    @Override
    public double Uygula(double tutar) {
        return tutar;
    }

    @Override
    public String toString() {
        return "IndirimYok";
    }
}
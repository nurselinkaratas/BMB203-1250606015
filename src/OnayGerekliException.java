public class OnayGerekliException extends Exception {
    private final int tahminiSaat;

    public OnayGerekliException(String mesaj, int tahminiSaat) {
        super(mesaj);
        this.tahminiSaat = tahminiSaat;
    }

    public int getTahminiSaat() { return tahminiSaat; }
}
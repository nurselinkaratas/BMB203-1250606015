public class CihazTeslimEdildiException extends Exception {
    private final int cihazId;

    public CihazTeslimEdildiException(String mesaj, int cihazId) {
        super(mesaj);
        this.cihazId = cihazId;
    }

    public int getCihazId() { return cihazId; }
}
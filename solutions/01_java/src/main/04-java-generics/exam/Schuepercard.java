package exam;

public class Schuepercard {
    private static int cardNumber = 0;
    private int schueperpoints = 0;

    public Schuepercard() {
        ++cardNumber;
    }

    public static int getCardNumber() {
        return cardNumber;
    }

    public void addSchueperpoints(double purchaseTotal) {
        schueperpoints += (int) Math.floor(purchaseTotal);
    }

    public int getSchueperpoints() {
        return schueperpoints;
    }
}

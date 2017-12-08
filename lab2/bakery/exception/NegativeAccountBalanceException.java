package lab2.bakery.exception;

public class NegativeAccountBalanceException extends Exception {
    public NegativeAccountBalanceException(String message) {
        super(message);
    }
}

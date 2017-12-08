package lab2.bakery.exception;

public class NegativeProductsQuantityException extends Exception {
    public NegativeProductsQuantityException(String message) {
        super(message);
    }
}

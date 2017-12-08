package lab2.bakery.exception;

public class NegativeIngredientsQuantityException extends Exception {
    public NegativeIngredientsQuantityException(String message) {
        super(message);
    }
}

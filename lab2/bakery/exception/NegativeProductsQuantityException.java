package lab2.bakery.exception;

/**
 * @author Кирилл
 * @version 1.0
 * Класс исключения отрицательного количества продукта на складе
 */
public class NegativeProductsQuantityException extends Exception {

    /**
     * Конструктор - передает конструктору суперкласса сообщение
     * @param message - сообщение, содержащее информацию об исключении
     */
    public NegativeProductsQuantityException(String message) {
        super(message);
    }
}

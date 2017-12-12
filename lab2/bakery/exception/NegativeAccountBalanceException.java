package lab2.bakery.exception;

/**
 * @author Кирилл
 * @version 1.0
 * Класс исключения отрицательного баланса счета
 */
public class NegativeAccountBalanceException extends Exception {

    /**
     * Конструктор - передает конструктору суперкласса сообщение
     * @param message - сообщение, содержащее информацию об исключении
     */
    public NegativeAccountBalanceException(String message) {
        super(message);
    }
}

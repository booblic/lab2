package lab2.bakery.exception;

/**
 * @author Кирилл
 * @version 1.0
 * Класс исключения отрицательного количества ингредиентов на складе
 */
public class NegativeIngredientsQuantityException extends ControllerException {

    /**
     * Конструктор - передает конструктору суперкласса сообщение
     * @param message - сообщение, содержащее информацию об исключении
     */
    public NegativeIngredientsQuantityException(String message) {
        super(message);
    }
}

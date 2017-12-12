package lab2.bakery.exception;

/**
 * @author Кирилл
 * @version 1.0
 * Класс исключения которое может генерировать метод run() класса Controller
 */
public class ControllerException extends Exception {

    /**
     * Конструктор - передает конструктору суперкласса сообщение
     * @param message - сообщение, содержащее информацию об исключении
     */
    public ControllerException(String message) {
        super(message);
    }
}

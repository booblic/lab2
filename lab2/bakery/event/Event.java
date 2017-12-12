package lab2.bakery.event;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

/**
 * @author Кирилл
 * @version 1.0
 * Класс описывающий поведение события
 */
public abstract class Event {

    /**
     * Время, после выполнения события
     */
    private long eventTime;

    /**
     * Время за которое выполняется событие
     */
    protected final long delayTime;

    /**
     * Конструктор - запоминает время выполнения события очередного события
     * @param delayTime - время выполнения события
     */
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    /**
     * Метод, прибавляет к текущему времени интервал задержки, чтобы вычислить время происхождения события
     */
    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    /**
     * Метод сообщает, что событие готово к запуску
     * @return - true/false
     */
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    /**
     * Конкретное действие определяют наследники данного класса
     */
    public abstract void action() throws NegativeIngredientsQuantityException;
}

package lab2.bakery.controller;

import lab2.bakery.event.Event;
import lab2.bakery.exception.ControllerException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Кирилл
 * @version 1.0
 * Класс описывающий ссистему управления, которая распоряжается событиями и запускает их обработку
 */
public class Controller {

    /**
     * Коллекция для хранения событий
     */
    private List<Event> eventList = new ArrayList<>();

    /**
     * Метод для добавления события в коллекцию событий
     * @param event - событие
     */
    public void addEvent(Event event) {
        eventList.add(event);
    }

    /**
     * Метод для просмотра и запуска событий, готовых к исполнению
     */
    public void run() throws ControllerException {
        while (eventList.size() > 0) {
            for (Event event: new ArrayList<>(eventList)) {
                if (event.ready()) {
                    event.action();
                    System.out.println(event);
                    eventList.remove(event);
                }
            }
        }
    }
}

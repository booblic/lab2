package lab2.bakery.controller;

import lab2.bakery.event.Event;
import lab2.bakery.exception.NegativeIngredientsQuantityException;
import lab2.bakery.exception.NegativeProductsQuantityException;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) {
        eventList.add(c);
    }
    public void run() throws NegativeIngredientsQuantityException {
        while (eventList.size() > 0) {
            for (Event e: new ArrayList<>(eventList)) {
                if (e.ready()) {
                    e.action();
                    System.out.println(e);
                    eventList.remove(e);
                }
            }
        }
    }
}

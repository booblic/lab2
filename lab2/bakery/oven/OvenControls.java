package lab2.bakery.oven;

import lab2.bakery.controller.Controller;
import lab2.bakery.event.Event;
import lab2.bakery.products.Products;

import java.lang.reflect.Method;

/**
 * @author Кирилл
 * @version 1.0
 * Класс представляющий печь
 */
public class OvenControls<T extends Products> extends Controller {

    /**
     * Максимальный размер печи в единицах продукции - хлеб
     */
    private static final int size = 10;

    /**
     * Количество единиц продукции, которое планируется произвести
     */
    private static int quantity;

    /**
     * Конструктор для инициализации количества единиц продукции
     * @param quantity - количество единиц продукции, которое планируется произвести
     */
    public OvenControls(int quantity){
        OvenControls.quantity = quantity;
    }

    /**
     * Метод, возвращающий размер печи
     * @return size - размер печи для продукции
     */
    public static int getSize() {
        return size;
    }

    /**
     * @author Кирилл
     * @version 1.0
     * Внутренний класс предсталяющий событие - испечь заданное количества единиц продукции
     */
    public class Bake extends Event {

        /**
         * Ссылка для рефлексивного создания продукции
         */
        Class<T> productClass;

        /**
         * Конструктор для инициализации времени неоходимого для происхождения события
         * @param delayTime - время за которой должно произойти событие
         * @param productClass - объект типа Class, соответствующий типу продукции
         */
        public Bake(long delayTime, Class<T> productClass) {
            super(delayTime);
            this.productClass = productClass;
        }

        /**
         * Метод, рефлексивно создающий заданный тип продукции
         */
        public void action() {
            try {
                Method method = productClass.getMethod("setQuantity", int.class);
                method.setAccessible(true);
                method.invoke(productClass.newInstance(), quantity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Метод, выводящий сообщение о том, что событие завершено
         */
        public String toString() {
            return "Испечено " + quantity + " единиц продукциии";
        }
    }

}

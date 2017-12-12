package lab2.bakery.menu;

import lab2.bakery.annotation.DefaultPrice;
import lab2.bakery.products.*;

import java.lang.reflect.Method;

/**
 * @author Кирилл
 * @version 1.0
 * Класс для отображения количества готовой продукции
 */
public class ShowProducts extends MenuEntry {

    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param input - заглавие мпункта меню
     */
    public ShowProducts(String input) {
        super(input);
    }

    /**
     * Метод, выводящий в консоль количество готовой продукции
     */
    public void go() {

        if (SingletonProducts.getBread().getPrice() == 0) {
            Method method = null;
            try {
                method = Products.class.getDeclaredMethod("getPrice");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (method.isAnnotationPresent(DefaultPrice.class)) {
                SingletonProducts.getBread().setPrice(method.getAnnotation(DefaultPrice.class).value());
            }
        }

        System.out.println("Склад готовой продукции\n");

        DecoratorProducts decoratorProducts = new DecoratorProductsMoney(SingletonProducts.getBread());

        System.out.println("Общая стоимость хлеба " + decoratorProducts.getQuantity() + " рублей");

    }
}

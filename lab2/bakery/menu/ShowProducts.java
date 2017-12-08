package lab2.bakery.menu;

import lab2.bakery.products.Bread;
import lab2.bakery.products.SingletonProducts;

public class ShowProducts extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public ShowProducts(String input) {
        super(input);
    }

    public void run() {

        System.out.println("Склад готовой продукции\n");

        Bread bread = new Bread();
        System.out.println(bread.getName() + ": " + bread.getQuantity() + " " + bread.getUnit());

    }
}

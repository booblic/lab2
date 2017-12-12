package lab2.bakery.menu;

import static lab2.bakery.ingredients.SingletoneIngredients.*;

/**
 * @author Кирилл
 * @version 1.0
 * Класс для отображения количества доступных ингредиентов
 */
public class ShowIngredients extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param input - заглавие мпункта меню
     */
    public ShowIngredients(String input) {
        super(input);
    }

    /**
     * Метод, выводящий в консоль количество доступных ингредиентов
     */
    public void go() {

        System.out.println("Склад ингредиентов\n");

        System.out.println(getFlour().getName() + ": " + String.format("%.2f", getFlour().getUnitQuantity()) + " (" + getFlour().getUnit() + ")");

        System.out.println(getSalt().getName() + ": " + String.format("%.2f", getSalt().getUnitQuantity()) + " (" + getSalt().getUnit() + ")");

        System.out.println(getVegetableOil().getName() + ": " + String.format("%.2f", getVegetableOil().getUnitQuantity()) + " (" + getVegetableOil().getUnit() + ")");

        System.out.println(getWater().getName() + ": " + String.format("%.2f", getWater().getUnitQuantity()) + " (" + getWater().getUnit() + ")");

        System.out.println(getYeast().getName() + ": " + String.format("%.2f", getYeast().getUnitQuantity()) + " (" + getYeast().getUnit() + ")");
    }
}

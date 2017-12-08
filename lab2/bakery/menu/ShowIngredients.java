package lab2.bakery.menu;

import lab2.bakery.ingredients.*;

import static lab2.bakery.ingredients.SingletoneIngredients.*;

public class ShowIngredients extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public ShowIngredients(String input) {
        super(input);
    }

    public void run() {

        System.out.println("Склад ингредиентов\n");

        Flour flour = getFlour();
        System.out.println(flour.getName() + ": " + String.format("%.2f", flour.getUnitQuantity()) + " (" + flour.getUnit() + ")");

        Salt salt = getSalt();
        System.out.println(salt.getName() + ": " + String.format("%.2f", salt.getUnitQuantity()) + " (" + salt.getUnit() + ")");

        VegetableOil vegetableOil = getVegetableOil();
        System.out.println(vegetableOil.getName() + ": " + String.format("%.2f", vegetableOil.getUnitQuantity()) + " (" + vegetableOil.getUnit() + ")");

        Water water = getWater();
        System.out.println(water.getName() + ": " + String.format("%.2f", water.getUnitQuantity()) + " (" + water.getUnit() + ")");

        Yeast yeast = getYeast();
        System.out.println(yeast.getName() + ": " + String.format("%.2f", yeast.getUnitQuantity()) + " (" + yeast.getUnit() + ")");
    }
}

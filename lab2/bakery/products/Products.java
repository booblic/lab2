package lab2.bakery.products;

import lab2.bakery.annotation.DefaultPrice;

/**
 * Родительский класс для всей продукции
 * @author Кирилл
 * @version 1.0
 */
public abstract class Products {

    /**
     * Цена одной единицы продукции
     */
    private double price;

    /**
     * Метод, для полученя цены одной единицы продукции
     * @return price - цена одной единицы продукци
     */
    @DefaultPrice
    public double getPrice() {
         return price;
     }

    /**
     * Метод, для изменения цены одной единицы продукции
     * @param newPrice - цена одной единицы продукци
     */
    public void setPrice(double newPrice) {
         this.price = newPrice;
     }

    /**
     * Абстрактный метод, для получения количества единиц продукции на складе
     * @return количества единиц продукции на складе
     */
    public abstract int getQuantity();

    /**
     * Абстрактный метод, для получения наименования продукции
     * @return наименование продукции
     */
    public abstract String getName();

    /**
     * Абстрактный метод, для получения наименования единицы измерения продукции
     * @return наименование единицы измерения продукции
     */
    public abstract String getUnit();
}

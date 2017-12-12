package lab2.bakery.products;

import lab2.bakery.exception.NegativeProductsQuantityException;

/**
 * Класс продукции - хлеб
 * @author Кирилл
 * @version 1.0
 */
public class Bread extends Products {

    /**
     * Наименование продукции
     */
    private String name = "Хлеб";

    /**
     * Наименование единицы измерения продукции
     */
    private String unit = "шт";

    /**
     * Количество единиц продукции
     */
    private static int quantityBread;

    /**
     * Явно определенный конструктор по умолчанию
     */
    public Bread() {}

    /**
     * Метод, для получения наименования продукции
     * @return name - наименование продукции
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, для получения наименования единицы измерения продукции
     * @return unit - наименование единицы измерения продукции
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Метод, для получения количества единиц продукции на складе
     * @return quantityBread - количества единиц продукции
     */
    public int getQuantity() {
        return quantityBread;
    }

    /**
     * Метод, для изменеия количества продукции
     * @param changeQuantity - число на которое необходимо изменит количество продукции
     * @throws NegativeProductsQuantityException - количество продукции не может быть отрицательным
     */
    public static void setQuantity(int changeQuantity) throws NegativeProductsQuantityException {
        if (quantityBread + changeQuantity < 0) {
            throw new NegativeProductsQuantityException("Для продажи доступно только " + quantityBread + " буханок хлеба!");
        }
        Bread.quantityBread += changeQuantity;
    }

}

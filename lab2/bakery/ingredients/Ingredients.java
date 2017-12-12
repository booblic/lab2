package lab2.bakery.ingredients;

/**
 * @author Кирилл
 * @version 1.0
 * Родительский класс всех ингредиентов
 */
public abstract class Ingredients {

    /**
     * Цена одной единицы ингредиента
     */
    private double unitPrice;

    /**
     * Конструктор - инициализирующий цену единицы ингредиента
     * @param unitPrice - цена единици ингредиента
     */
    public Ingredients(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Метод, для получения цены единицы ингредиента
     * @return unitPrice - цена одной единицы ингредиента
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Метод, для изменения цены единицы ингредиента
     * @param newUnitePrice - цена одной единицы ингредиента
     */
    public void setUnitePrice(double newUnitePrice) {
        unitPrice = newUnitePrice;
    }

    /**
     * Метод, для получения наименования единицы ингредиента
     * @return наименование единицы ингредиента
     */
    public abstract String getUnit();

    /**
     * Метод, для получения наименования ингредиента
     * @return наименование ингредиента
     */
    public abstract String getName();

    /**
     * Метод, для получения количества единиц ингредиента на складе
     * @return количество единиц ингредиента на складе
     */
    public abstract double getUnitQuantity();
}

package lab2.bakery.ingredients;

import lab2.bakery.constants.Constants;
import lab2.bakery.exception.NegativeIngredientsQuantityException;

/**
 * @author Кирилл
 * @version 1.0
 * Класс ингредиента - растительное масло
 */
public class VegetableOil extends Ingredients {

    /**
     * Наименование игредиента
     */
    private String name = "Растительное масло";

    /**
     * Единица измерения ингредиента
     */
    private String unit = "л";

    /**
     * Текущее количество единиц ингредиента
     */
    private double unitQuantity;

    /**
     * Конструктор - инициализирующий стоимость единицы ингредиента родительского класса и количество единиц ингредиента
     * @see lab2.bakery.ingredients.Ingredients
     * @param price - цена единици ингредиента
     * @param unitQuantity - количество единиц ингредиента
     */
    public VegetableOil(double price, double unitQuantity) {
        super(price);
        this.unitQuantity = unitQuantity;
    }

    /**
     * Метод, дл получения текущего количества единиц ингредиента
     * @return unitQuantity - текущее количество единиц ингредиента
     */
    public double getUnitQuantity() {
        return unitQuantity;
    }

    /**
     * Метод для изменения текущего количества единиц ингредиента
     * @param changeQuantity - число на которое необходимо изменить текущее количество единиц ингредиента
     */
    public void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException(getName() + Constants.NOT_ENOUGH + String.format("%.2f", - unitQuantity - changeQuantity) + getUnit());
        }
        unitQuantity += changeQuantity;
    }

    /**
     * Метод для получения наименования ингредиента
     * @return name - наименование ингредиента
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Метод для получения единицы измерения ингредиента
     * @return unit - единица измерения ингредиента
     */
    public String getName() {
        return name;
    }
}

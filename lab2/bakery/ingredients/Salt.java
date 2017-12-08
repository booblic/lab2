package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class Salt extends Ingredients {

    private String name = "Соль";

    private String unit = "кг";

    private static double unitQuantity;

    public Salt(double price, double unitQuantity) {
        super(price);
        Salt.unitQuantity = unitQuantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public static void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException("Не хватает " + String.format("%.2f", - unitQuantity - changeQuantity) + " кг соли!");
        }
        unitQuantity += changeQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}

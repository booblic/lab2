package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class Water extends Ingredients {

    private String name = "Вода";

    private String unit = "л";

    private static double unitQuantity;

    public Water(double price, double unitQuantity) {
        super(price);
        Water.unitQuantity = unitQuantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public static void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException("Не хватает " + String.format("%.2f", - unitQuantity - changeQuantity) + " л воды!");
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

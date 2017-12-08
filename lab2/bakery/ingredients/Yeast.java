package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class Yeast extends Ingredients {

    private String name = "Дрожжи";

    private String unit = "кг";

    private static double unitQuantity;

    public Yeast(double price, double unitQuantity) {
        super(price);
        Yeast.unitQuantity = unitQuantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public static void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException("Не хватает " + String.format("%.2f", - unitQuantity - changeQuantity) + " кг дрожжей!");
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

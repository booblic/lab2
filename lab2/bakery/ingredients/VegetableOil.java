package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class VegetableOil extends Ingredients {

    private String name = "Растительное масло";

    private String unit = "л";

    private double unitQuantity;

    public VegetableOil(double price, double unitQuantity) {
        super(price);
        this.unitQuantity = unitQuantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException("Не хватает " + String.format("%.2f", - unitQuantity - changeQuantity) + " л растительного масла!");
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

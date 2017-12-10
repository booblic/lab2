package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class Flour extends Ingredients {

    private String name = "Мука";

    private String unit = "кг";

    private double unitQuantity;

    public Flour(double price, double unitQuantity) {
        super(price);
        this.unitQuantity = unitQuantity;
    }

    public double getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(double changeQuantity) throws NegativeIngredientsQuantityException {
        if (unitQuantity + changeQuantity < 0) {
            throw new NegativeIngredientsQuantityException("Не хватает " + String.format("%.2f", - unitQuantity - changeQuantity) + " кг муки!");
        }
        unitQuantity += changeQuantity;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

}

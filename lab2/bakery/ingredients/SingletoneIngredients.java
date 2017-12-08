package lab2.bakery.ingredients;

import lab2.bakery.accounting.SingletoneAccounting;
import lab2.bakery.exception.NegativeIngredientsQuantityException;

public class SingletoneIngredients {

    private static Flour flour;
    private static Salt salt;
    private static VegetableOil vegetableOil;
    private static Water water;
    private static Yeast yeast;

    private SingletoneIngredients() {}

    public static Flour getFlour() {
        return flour;
    }

    public static Flour getFlour(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (flour == null) {
            flour = new Flour(unitPrice, unitQuantity);
        } else {
            flour.setUnitePrice(unitPrice);
            flour.setUnitQuantity(unitQuantity);
        }
        return flour;
    }

    public static Salt getSalt() {
        return salt;
    }

    public static Salt getSalt(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (salt == null) {
            salt = new Salt(unitPrice, unitQuantity);
        } else {
            salt.setUnitePrice(unitPrice);
            salt.setUnitQuantity(unitQuantity);
        }
        return salt;
    }

    public static VegetableOil getVegetableOil() {
        return vegetableOil;
    }

    public static VegetableOil getVegetableOil(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (vegetableOil == null) {
            vegetableOil = new VegetableOil(unitPrice, unitQuantity);
        } else {
            vegetableOil.setUnitePrice(unitPrice);
            vegetableOil.setUnitQuantity(unitQuantity);
        }
        return vegetableOil;
    }

    public static Water getWater() {
        return water;
    }

    public static Water getWater(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (water == null) {
            water = new Water(unitPrice, unitQuantity);
        } else {
            water.setUnitePrice(unitPrice);
            water.setUnitQuantity(unitQuantity);
        }
        return water;
    }

    public static Yeast getYeast() {
        return yeast;
    }

    public static Yeast getYeast(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (yeast == null) {
            yeast = new Yeast(unitPrice, unitQuantity);
        } else {
            yeast.setUnitePrice(unitPrice);
            yeast.setUnitQuantity(unitQuantity);
        }
        return yeast;
    }
}

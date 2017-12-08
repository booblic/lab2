package lab2.bakery.products;

import lab2.bakery.exception.NegativeIngredientsQuantityException;
import lab2.bakery.exception.NegativeProductsQuantityException;

public class Bread extends Products {

    private String name = "Хлеб";

    private String unit = "шт";

    private static int quantityBread;

    public Bread() {}

    //public Bread(int quantityBread) {
        //Bread.quantityBread = quantityBread;
    //}

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public static int getQuantity() {
        return quantityBread;
    }

    public static void setQuantity(int changeQuantity) throws NegativeProductsQuantityException {
        if (quantityBread + changeQuantity < 0) {
            throw new NegativeProductsQuantityException("Для продажи доступно только " + quantityBread + " буханок хлеба!");
        }
        Bread.quantityBread += changeQuantity;
    }

}
package lab2.bakery.ingredients;

public abstract class Ingredients {

    private static double unitPrice;

    public Ingredients(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public static void setUnitePrice(double newUnitePrice) {
        unitPrice = newUnitePrice;
    }

    public abstract String getUnit();

    public abstract String getName();

    public abstract double getUnitQuantity();
}

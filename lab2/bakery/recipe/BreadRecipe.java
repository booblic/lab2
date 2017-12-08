package lab2.bakery.recipe;

public enum BreadRecipe {
    FLOURF(0.2), SALT(0.01), VEGETABLEOIL(0.05), WATER(0.2), YEAST(0.01);

    private double value;

    BreadRecipe(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

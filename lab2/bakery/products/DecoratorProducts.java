package lab2.bakery.products;

public class DecoratorProducts extends Products {
    protected Products products;

    public DecoratorProducts(Products products) {
        this.products = products;
    }

    @Override
    public int getQuantity() {
        System.out.println(products.getName() + ": " + products.getQuantity() + " " + products.getUnit());
        return products.getQuantity();
    }

    @Override
    public String getName() {
        return products.getName();
    }

    @Override
    public String getUnit() {
        return products.getUnit();
    }
}

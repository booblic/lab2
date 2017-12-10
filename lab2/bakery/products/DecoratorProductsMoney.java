package lab2.bakery.products;

public class DecoratorProductsMoney extends DecoratorProducts {

    public DecoratorProductsMoney(Products products) {
        super(products);
    }

    @Override
    public int getQuantity() {
        return (int) super.products.getPrice() * super.getQuantity();
    }
}

package lab2.bakery.products;

import lab2.bakery.annotation.DefaultPrice;

public abstract class Products {

    private double price;

    @DefaultPrice
    public double getPrice() {
         return price;
     }

    public void setPrice(double newPrice) {
         this.price = newPrice;
     }

    public abstract int getQuantity();

    public abstract String getName();

    public abstract String getUnit();
}

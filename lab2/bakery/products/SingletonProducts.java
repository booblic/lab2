package lab2.bakery.products;

import lab2.bakery.exception.NegativeProductsQuantityException;

public class SingletonProducts {
    private static Bread bread;

    private SingletonProducts() {}

    public static Bread getBread() {
        return bread;
    }

    public static Bread getBread(int quantityBread) throws NegativeProductsQuantityException {
        if (bread == null) {
            //bread = new Bread(quantityBread);
        } else {
            bread.setQuantity(quantityBread);
        }
        return bread;
    }
}

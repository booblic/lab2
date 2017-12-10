package lab2.bakery.products;

public class SingletonProducts {
    private static Bread bread;

    private SingletonProducts() {}

    public static Bread getBread() {
        if (bread == null) {
            bread = new Bread();
        }
        return bread;
    }
}

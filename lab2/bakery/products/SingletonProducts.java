package lab2.bakery.products;

/**
 * Класс для хранения экземпляра продукта
 * @author Кирилл
 * @version 1.0
 */
public class SingletonProducts {

    /**
     * Ссылка на продукт - хлеб
     */
    private static Bread bread;

    /**
     * Конструктор для запреда создания экземпляров данного класса
     */
    private SingletonProducts() {}

    /**
     * Метод, для получания экземпляра продукта - хлеб
     * @return  bread - экземпляр продукта - хлеб
     */
    public static Bread getBread() {
        if (bread == null) {
            bread = new Bread();
        }
        return bread;
    }
}

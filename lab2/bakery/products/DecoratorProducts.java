package lab2.bakery.products;

/**
 * Класс декоратор продукции, служащий для расширения возможности просмотра количества продукции
 * @author Кирилл
 * @version 1.0
 */
public class DecoratorProducts extends Products {

    /**
     * Ссылка для харнения объектов продукта
     */
    protected Products products;

    /**
     * Конструктор сохраняющий ссылку на подкласс продукта
     * @param products - любой продукт
     */
    public DecoratorProducts(Products products) {
        this.products = products;
    }

    /**
     * Метод для вывода в консоль информации о количестве продукта
     * @return количество продукта
     */
    @Override
    public int getQuantity() {
        System.out.println(products.getName() + ": " + products.getQuantity() + " " + products.getUnit());
        return products.getQuantity();
    }

    /**
     * Метод для получения наименования продукции
     * @return name - наименование продукции
     */
    @Override
    public String getName() {
        return products.getName();
    }

    /**
     * Метод для получения наименования единицы измерения продукции
     * @return unit - наименование единицы измерения продукции
     */
    @Override
    public String getUnit() {
        return products.getUnit();
    }
}

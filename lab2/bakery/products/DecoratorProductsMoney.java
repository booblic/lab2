package lab2.bakery.products;

/**
 * Класс декоратор продукции, служащий для расширения возможности просмотра количества продукции - просмотр в денежном эквиваленте
 * @author Кирилл
 * @version 1.0
 */
public class DecoratorProductsMoney extends DecoratorProducts {

    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param products - любой продукт
     */
    public DecoratorProductsMoney(Products products) {
        super(products);
    }

    /**
     * Метод для вывода в консоль информации о количестве продукта в денежном эквиваленте
     * @return количество продукта
     */
    @Override
    public int getQuantity() {
        return (int) super.products.getPrice() * super.getQuantity();
    }
}

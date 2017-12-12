package lab2.bakery.recipe;

/**
 * @author Кирилл
 * @version 1.0
 * Перечисляемы тип содержащий рецепт хлеба
 */
public enum BreadRecipe {
    FLOURF(0.2), SALT(0.01), VEGETABLEOIL(0.05), WATER(0.2), YEAST(0.01);

    /**
     * Количество ингредиента для создания одной единицы продукции
     */
    private double value;

    /**
     * Конструктор для инициализации количества ингредиента, необходимого для создания одной единицы продукции
     * @param value - количество ингредиента
     */
    BreadRecipe(double value) {
        this.value = value;
    }

    /**
     * Метод, возвращающий количество ингредиента для создания одной единицы продукции
     * @return value - количество ингредиента для создания одной единицы продукции
     */
    public double getValue() {
        return value;
    }
}

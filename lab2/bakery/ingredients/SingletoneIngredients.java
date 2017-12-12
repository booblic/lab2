package lab2.bakery.ingredients;

import lab2.bakery.exception.NegativeIngredientsQuantityException;

/**
 * Класс для хранения экземпляров ингредиентов
 * @author Кирилл
 * @version 1.0
 */
public class SingletoneIngredients {

    /**
     * Ссылка на ингредиент - мука
     */
    private static Flour flour;

    /**
     * Ссылка на ингредиент - соль
     */
    private static Salt salt;

    /**
     * Ссылка на ингредиент - растительное масло
     */
    private static VegetableOil vegetableOil;

    /**
     * Ссылка на ингредиент - вода
     */
    private static Water water;

    /**
     * Ссылка на ингредиент - дрожжи
     */
    private static Yeast yeast;

    /**
     * Конструктор для запреда создания экземпляров данного класса
     */
    private SingletoneIngredients() {}

    /**
     * Метод, для создания или получания экземпляра ингредиента - мука
     * @return  flour - экземпляр ингредиента - мука
     */
    public static Flour getFlour() {
        if (flour == null) {
            flour = new Flour(0, 0);
        }
        return flour;
    }

    /**
     * Метод, для создания, получания или изменеия экземпляра ингредиента - мука
     * @param unitPrice - цена единицы ингредиента
     * @param unitQuantity - количество единиц ингредиента
     * @return  flour - экземпляр ингредиента - мука
     */
    public static Flour getFlour(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (flour == null) {
            flour = new Flour(unitPrice, unitQuantity);
        } else {
            flour.setUnitePrice(unitPrice);
            flour.setUnitQuantity(unitQuantity);
        }
        return flour;
    }

    /**
     * Метод, для создания или получания экземпляра ингредиента - соль
     * @return  flour - экземпляр ингредиента - соль
     */
    public static Salt getSalt() {
        if (salt == null) {
            salt = new Salt(0, 0);
        }
        return salt;
    }

    /**
     * Метод, для создания, получания или изменеия экземпляра ингредиента - соль
     * @param unitPrice - цена единицы ингредиента
     * @param unitQuantity - количество единиц ингредиента
     * @return  salt - экземпляр ингредиента - соль
     */
    public static Salt getSalt(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (salt == null) {
            salt = new Salt(unitPrice, unitQuantity);
        } else {
            salt.setUnitePrice(unitPrice);
            salt.setUnitQuantity(unitQuantity);
        }
        return salt;
    }

    /**
     * Метод, для создания или получания экземпляра ингредиента - растительное малсо
     * @return  flour - экземпляр ингредиента - растительное масло
     */
    public static VegetableOil getVegetableOil() {
        if (vegetableOil == null) {
            vegetableOil = new VegetableOil(0, 0);
        }
        return vegetableOil;
    }

    /**
     * Метод, для создания, получания или изменеия экземпляра ингредиента - растительное малсо
     * @param unitPrice - цена единицы ингредиента
     * @param unitQuantity - количество единиц ингредиента
     * @return  vegetableOil - экземпляр ингредиента - растительное малсо
     * @throws NegativeIngredientsQuantityException - отрицательное количество ингредиентов
     */
    public static VegetableOil getVegetableOil(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (vegetableOil == null) {
            vegetableOil = new VegetableOil(unitPrice, unitQuantity);
        } else {
            vegetableOil.setUnitePrice(unitPrice);
            vegetableOil.setUnitQuantity(unitQuantity);
        }
        return vegetableOil;
    }

    /**
     * Метод, для создания или получания экземпляра ингредиента - вода
     * @return  flour - экземпляр ингредиента - вода
     */
    public static Water getWater() {
        if (water == null) {
            water = new Water(0, 0);
        }
        return water;
    }

    /**
     * Метод, для создания, получания или изменеия экземпляра ингредиента - вода
     * @param unitPrice - цена единицы ингредиента
     * @param unitQuantity - количество единиц ингредиента
     * @return  water - экземпляр ингредиента - вода
     * @throws NegativeIngredientsQuantityException - отрицательное количество ингредиентов
     */
    public static Water getWater(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (water == null) {
            water = new Water(unitPrice, unitQuantity);
        } else {
            water.setUnitePrice(unitPrice);
            water.setUnitQuantity(unitQuantity);
        }
        return water;
    }

    /**
     * Метод, для создания или получания экземпляра ингредиента - дрожжи
     * @return  flour - экземпляр ингредиента - дрожжи
     */
    public static Yeast getYeast() {
        if (yeast == null) {
            yeast = new Yeast(0, 0);
        }
            return yeast;
    }

    /**
     * Метод, для создания, получания или изменеия экземпляра ингредиента - дрожжи
     * @param unitPrice - цена единицы ингредиента
     * @param unitQuantity - количество единиц ингредиента
     * @return  yeast - экземпляр ингредиента - дрожжи
     * @throws NegativeIngredientsQuantityException - отрицательное количество ингредиентов
     */
    public static Yeast getYeast(double unitPrice, double unitQuantity) throws NegativeIngredientsQuantityException {
        if (yeast == null) {
            yeast = new Yeast(unitPrice, unitQuantity);
        } else {
            yeast.setUnitePrice(unitPrice);
            yeast.setUnitQuantity(unitQuantity);
        }
        return yeast;
    }
}

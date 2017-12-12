package lab2.bakery.mixer;

import lab2.bakery.controller.Controller;
import lab2.bakery.event.Event;
import lab2.bakery.exception.NegativeIngredientsQuantityException;
import lab2.bakery.recipe.BreadRecipe;

import static lab2.bakery.ingredients.SingletoneIngredients.*;

/**
 * @author Кирилл
 * @version 1.0
 * Класс представляющий миксер для замешивания теста для хдеба
 */
public class BreadMixerControls extends Controller {

    /**
     * Максимальный размер миксера в единицах продукции - хлеб
     */
    private static final int size = 20;

    private boolean selector = false;

    /**
     * Количество единиц продукции, которое планируется произвести
     */
    private int quantityBread;

    /**
     * Количество ингредиента - мука, требуемого для производства одной единициы продукции
     */
    private BreadRecipe quantityFlourForOneBread = BreadRecipe.FLOURF;

    /**
     * Количество единиц продукции - вода, которое планируется произвести
     */
    private BreadRecipe quantityWaterForOneBread = BreadRecipe.WATER;

    /**
     * Количество единиц продукции - соль, которое планируется произвести
     */
    private BreadRecipe quantitySaltForOneBread = BreadRecipe.SALT;

    /**
     * Количество единиц продукции - дрожжи, которое планируется произвести
     */
    private BreadRecipe quantityYeastForOneBread = BreadRecipe.YEAST;

    /**
     * Количество единиц продукции - растительное масло, которое планируется произвести
     */
    private BreadRecipe quantityVegetableOilForOneBread = BreadRecipe.VEGETABLEOIL;

    /**
     * Строка для формирования сообщения о недостающийх ингредиентов для изготовления запланированного количества единиц продукции
     */
    StringBuilder need = new StringBuilder("Не хватает: \n");

    /**
     * Конструктор для инициализации количества единиц продукции
     * @param quantityBread - количество единиц продукции, которое планируется произвести
     */
    public BreadMixerControls(int quantityBread) {
        this.quantityBread = quantityBread;
    }

    /**
     * Метод, возвращающий размер миксера для создания продукции - хлеб
     * @return size - размер миксера для продукции - хлеб
     */
    public static int getSize() {
        return size;
    }

    /**
     * @author Кирилл
     * @version 1.0
     * Внутренний класс предсталяющий событие - получение ингредиентов для создания заданного количества единиц продукции
     */
    public class GetIngredients extends Event {

        /**
         * Конструктор для инициализации времени неоходимого для происхождения события
         * @param delayTime - время за которой должно произойти событие
         */
        public GetIngredients(long delayTime) {
            super(delayTime);
        }

        /**
         * Метод, проверяющий досточно ли ингредиенов на складе для производства запланированного количества единиц продукции
         * @return true/false - размер миксера для продукции - хлеб
         */
        public boolean checkIngredients() {

            boolean check = true;

            if (getFlour().getUnitQuantity() < quantityBread * quantityFlourForOneBread.getValue()) {
                need = need.append(getFlour().getName() + " - " + String.format("%.2f", quantityBread * quantityFlourForOneBread.getValue() - getFlour().getUnitQuantity()) + " " + getFlour().getUnit() + "\n");
                check = false;
            }

            if (getSalt().getUnitQuantity() < quantityBread * quantitySaltForOneBread.getValue()) {
                need = need.append(getSalt().getName() + " - " + String.format("%.2f", quantityBread * quantitySaltForOneBread.getValue() - getSalt().getUnitQuantity()) + " " + getSalt().getUnit() + "\n");
                check = false;
            }

            if (getWater().getUnitQuantity() < quantityBread * quantityWaterForOneBread.getValue()) {
                need = need.append(getWater().getName() + " - " + String.format("%.2f", quantityBread * quantityWaterForOneBread.getValue() - getWater().getUnitQuantity()) + " " + getWater().getUnit() + "\n");
                check = false;
            }

            if (getYeast().getUnitQuantity() < quantityBread * quantityYeastForOneBread.getValue()) {
                need = need.append(getYeast().getName() + " - " + String.format("%.2f", quantityBread * quantityYeastForOneBread.getValue() - getYeast().getUnitQuantity()) + " " + getYeast().getUnit() + "\n");
                check = false;
            }

            if (getVegetableOil().getUnitQuantity() < quantityBread * quantityYeastForOneBread.getValue()) {
                need = need.append(getVegetableOil().getName() + " - " + String.format("%.2f", quantityBread * quantityYeastForOneBread.getValue() - getVegetableOil().getUnitQuantity()) + " " + getVegetableOil().getUnit() + "\n");
                check = false;
            }
            return check;
        }

        /**
         * Метод, забирающий со склада неоюходимое количество ингредиентов
         */
        public void action() throws NegativeIngredientsQuantityException {

            if (this.checkIngredients()) {
                getFlour().setUnitQuantity(-quantityFlourForOneBread.getValue() * quantityBread);
                getSalt().setUnitQuantity(-quantitySaltForOneBread.getValue() * quantityBread);
                getWater().setUnitQuantity(-quantityWaterForOneBread.getValue() * quantityBread);
                getYeast().setUnitQuantity(-quantityYeastForOneBread.getValue() * quantityBread);
                getVegetableOil().setUnitQuantity(-quantityVegetableOilForOneBread.getValue() * quantityBread);
            } else {
                throw new NegativeIngredientsQuantityException(need.toString());
            }
        }

        /**
         * Метод, выводящий сообщение о том, что событие завершено
         */
        public String toString() {
            return "Компоненты для замешиывания " + quantityBread + " буханок хлеба получены";
        }
    }

    /**
     * @author Кирилл
     * @version 1.0
     * Внутренний класс предсталяющий событие - замесить тесто
     */
    public class Knead extends Event {

        /**
         * Конструктор для инициализации времени неоходимого для происхождения события
         * @param delayTime - время за которой должно произойти событие
         */
        public Knead(long delayTime) {
            super(delayTime);
        }

        /**
         * Метод, выполнябщий замес теста
         */
        public void action() {
            selector = true;
        }

        /**
         * Метод, выводящий сообщение о том, что событие завершено
         */
        public String toString() {
            return "Партия из " + quantityBread + " буханок готова к выпески";
        }
    }
}

package lab2.bakery.mixer;

import lab2.bakery.controller.Controller;
import lab2.bakery.event.Event;
import lab2.bakery.exception.NegativeIngredientsQuantityException;
import lab2.bakery.ingredients.*;
import lab2.bakery.recipe.BreadRecipe;

import static lab2.bakery.ingredients.SingletoneIngredients.*;

public class BreadMixerControls extends Controller {

    private static final int size = 20;

    private boolean selector = false;

    private int quantityBread;

    private BreadRecipe quantityFlourForOneBread = BreadRecipe.FLOURF;

    private BreadRecipe quantityWaterForOneBread = BreadRecipe.WATER;

    private BreadRecipe quantitySaltForOneBread = BreadRecipe.SALT;

    private BreadRecipe quantityYeastForOneBread = BreadRecipe.YEAST;

    private BreadRecipe quantityVegetableOilForOneBread = BreadRecipe.VEGETABLEOIL;

    StringBuilder need = new StringBuilder("Не хватает: \n");

    public BreadMixerControls(int quantityBread) {

        this.quantityBread = quantityBread;
    }

    public static int getSize() {
        return size;
    }

    public class GetIngredients extends Event {

        public GetIngredients(long delayTime) {
            super(delayTime);
        }

        public boolean checkIngredients() {

            boolean check = true;

            Flour flour = getFlour();

            if (flour.getUnitQuantity() < quantityBread * quantityFlourForOneBread.getValue()) {
                need = need.append(flour.getName() + " - " + String.format("%.2f", quantityBread * quantityFlourForOneBread.getValue() - flour.getUnitQuantity()) + " " + flour.getUnit() + "\n");
                check = false;
            }

            Salt salt = getSalt();

            if (salt.getUnitQuantity() < quantityBread * quantitySaltForOneBread.getValue()) {
                need = need.append(salt.getName() + " - " + String.format("%.2f", quantityBread * quantitySaltForOneBread.getValue() - salt.getUnitQuantity()) + " " + salt.getUnit() + "\n");
                check = false;
            }

            Water water = getWater();

            if (water.getUnitQuantity() < quantityBread * quantityWaterForOneBread.getValue()) {
                need = need.append(water.getName() + " - " + String.format("%.2f", quantityBread * quantityWaterForOneBread.getValue() - water.getUnitQuantity()) + " " + water.getUnit() + "\n");
                check = false;
            }

            Yeast yeast = getYeast();

            if (yeast.getUnitQuantity() < quantityBread * quantityYeastForOneBread.getValue()) {
                need = need.append(yeast.getName() + " - " + String.format("%.2f", quantityBread * quantityYeastForOneBread.getValue() - yeast.getUnitQuantity()) + " " + yeast.getUnit() + "\n");
                check = false;
            }

            VegetableOil vegetableOil = getVegetableOil();

            if (vegetableOil.getUnitQuantity() < quantityBread * quantityYeastForOneBread.getValue()) {
                need = need.append(vegetableOil.getName() + " - " + String.format("%.2f", quantityBread * quantityYeastForOneBread.getValue() - vegetableOil.getUnitQuantity()) + " " + vegetableOil.getUnit() + "\n");
                check = false;
            }
            return check;
        }

        public void action() throws NegativeIngredientsQuantityException {

            /*getFlour().setUnitQuantity(-quantityFlourForOneBread * quantityBread);
            getSalt().setUnitQuantity(-quantitySaltForOneBread * quantityBread);
            getWater().setUnitQuantity(-quantityWaterForOneBread * quantityBread);
            getYeast().setUnitQuantity(-quantityYeastForOneBread * quantityBread);
            getVegetableOil().setUnitQuantity(-quantityVegetableOilForOneBread * quantityBread);*/

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

        public String toString() {
            return "Ингредиенты для замешиывания " + quantityBread + " буханок хлеба получены";
        }
    }

    public class Knead extends Event {

        public Knead(long delayTime) {
            super(delayTime);
        }

        public void action() {
            selector = true;
        }

        public String toString() {
            return "Партия из " + quantityBread + " буханок готова к выпеканию";
        }
    }
}

package lab2.bakery.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lab2.bakery.constants.Constants;
import lab2.bakery.exception.ControllerException;
import lab2.bakery.mixer.*;
import lab2.bakery.oven.OvenControls;
import lab2.bakery.products.Bread;

/**
 * Класс для создания продукции - хлеб
 * @author Кирилл
 * @version 1.0
 */
public class BreadCreator extends MenuEntry {

    /**
     * Количество единиц продукции, которое планируется изготовить
     */
    private int quantity;

    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param input - заглавие мпункта меню
     */
    public BreadCreator(String input) {
        super(input);
    }

    /**
     * Метод, содержащий алгоритм для создания продукции - хлеб
     */
    public void go() {

        System.out.print("Введите количество буханок, которое планируется испечь: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            quantity = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println(Constants.INVALID_INPUT);
            return;
        }

        if (quantity <= 0) {
            System.out.println(Constants.INVALID_INPUT);
            return;
        }

        if (quantity > BreadMixerControls.getSize()) {

            int number = quantity;

            System.out.println("За раз в тестомесе можно замесить тесто только для " + BreadMixerControls.getSize() + " буханок!");
            System.out.println("Буханки будут подготовлены к выпечки частями");

            while (number > BreadMixerControls.getSize()) {
                BreadMixerControls breadMixerControls = new BreadMixerControls(BreadMixerControls.getSize());

                breadMixerControls.addEvent(breadMixerControls.new GetIngredients(1000));
                breadMixerControls.addEvent(breadMixerControls.new Knead(5000));
                try {
                    breadMixerControls.run();
                } catch (ControllerException e) {
                    e.printStackTrace();
                    System.out.println("Закупите недостающие ингредиенты.");
                }

                if (BreadMixerControls.getSize() > OvenControls.getSize()) {
                    int breadMixerSize = BreadMixerControls.getSize();

                    while (breadMixerSize >= OvenControls.getSize()) {

                        OvenControls<Bread> ovenControls = new OvenControls<>(OvenControls.getSize());

                        ovenControls.addEvent(ovenControls.new Bake(10000, Bread.class));
                        try {
                            ovenControls.run();
                        } catch (ControllerException e) {
                            e.printStackTrace();
                        }

                        breadMixerSize -= OvenControls.getSize();
                    }
                }

                number -= BreadMixerControls.getSize();
                quantity -= BreadMixerControls.getSize();
            }
        }

        BreadMixerControls breadMixerControls = new BreadMixerControls(quantity);

        breadMixerControls.addEvent(breadMixerControls.new GetIngredients(1000));
        breadMixerControls.addEvent(breadMixerControls.new Knead(5000));
        try {
            breadMixerControls.run();
        } catch (ControllerException e) {
            System.out.println(e.getMessage());
            System.out.println("Закупите недостающие ингредиенты.");
            return;
        }

        System.out.println("Всего было подготовленно " + quantity + " буханок для выпечки");

        if (quantity > OvenControls.getSize()) {

            while (quantity >= OvenControls.getSize()) {

                OvenControls<Bread> ovenControls = new OvenControls<>(OvenControls.getSize());

                ovenControls.addEvent(ovenControls.new Bake(10000, Bread.class));

                try {
                    ovenControls.run();
                } catch (ControllerException e) {
                    e.printStackTrace();
                }
                quantity -= OvenControls.getSize();
            }
        }

        OvenControls<Bread> ovenControls = new OvenControls<>(quantity);

        ovenControls.addEvent(ovenControls.new Bake(10000, Bread.class));

        try {
            ovenControls.run();
        } catch (ControllerException e) {
            e.printStackTrace();
        }


        System.out.println("На склад поступило " + quantity + " ед. продукции");

        Menu.addEntry(new ShowProducts("Посмотреть количество готовой продукции"));

        Menu.addEntry(new SellProducts("Продать готовую продукцию"));

    }
}

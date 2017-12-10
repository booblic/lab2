package lab2.bakery.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import lab2.bakery.accounting.Accounting;
import lab2.bakery.annotation.MinFund;
import lab2.bakery.constants.Constants;
import lab2.bakery.exception.NegativeAccountBalanceException;

/**
 * Класс для первого пункта меню, соответсвующему считыванию выражения из файла
 * @author Кирилл
 * @version 1.0
 */
public class CreateBakery extends MenuEntry {

    private double money;

    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public CreateBakery(String input) {
        super(input);
    }

    /**
     * Метод содержащий последовательнсть действий пункта меню
     */
    public void run() {

        Accounting accounting = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print(Constants.ENTR_MENU_POINT);
            money = Integer.parseInt(reader.readLine());

            Method method = Accounting.class.getDeclaredMethod("setMoney", double.class);
            if (method.isAnnotationPresent(MinFund.class)) {
                if (money < method.getAnnotation(MinFund.class).value()) {
                    System.out.println("Минимальный стартовый капитал 1000 рублей!");
                    Accounting.setMoney(method.getAnnotation(MinFund.class).value());
                } else {
                    Accounting.setMoney(money);
                }
            }

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод!");
            return;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NegativeAccountBalanceException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Баланс счета: " + Accounting.getMoney());

        Menu.deleteEntry("Создасть хлебзавод.");

        Menu.addEntry(new BuyIngredients("Закупить ингредиенты."));

        Menu.addEntry(new ShowMoney("Посмотреть баланс счета."));

    }
}

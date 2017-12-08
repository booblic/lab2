package lab2.bakery.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lab2.bakery.accounting.Accounting;
import lab2.bakery.accounting.SingletoneAccounting;
import lab2.bakery.constant.ClassOfConstant;
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
            System.out.print(ClassOfConstant.ENTR_MENU_POINT);
            money = Integer.parseInt(reader.readLine());

            SingletoneAccounting.getAccounting(money);

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод!");
            return;
        } catch (NegativeAccountBalanceException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Баланс счета: " + SingletoneAccounting.getAccounting().getMoney());

        Menu.deleteEntry("Создасть хлебзавод.");

        Menu.addEntry(new BuyIngredients("Закупить ингредиенты."));

        Menu.addEntry(new ShowMoney("Посмотреть баланс счета."));

    }
}

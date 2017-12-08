package lab2.bakery.menu;

import lab2.bakery.accounting.Accounting;
import lab2.bakery.accounting.SingletoneAccounting;

public class ShowMoney extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public ShowMoney(String input) {
        super(input);
    }

    public void run() {

        System.out.println("Текущий баланс счет: " + SingletoneAccounting.getAccounting().getMoney());

    }
}

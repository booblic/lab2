package lab2.bakery.menu;

import lab2.bakery.accounting.Accounting;

/**
 * @author Кирилл
 * @version 1.0
 * Класс для отображения баланса счета
 */
public class ShowMoney extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param input - заглавие мпункта меню
     */
    public ShowMoney(String input) {
        super(input);
    }

    /**
     * Метод, выводящий в консоль баланс счета
     */
    public void go() {

        System.out.println("Текущий баланс счет: " + Accounting.getMoney());

    }
}

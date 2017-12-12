package lab2.bakery.accounting;

import lab2.bakery.exception.NegativeAccountBalanceException;

import lab2.bakery.annotation.MinFund;

/**
 * @author Кирилл
 * @version 1.0
 * Класс для работы с бюджетом
 */
public class Accounting {

    /**
     * Переменная для хранения баланса счета
     */
    private static double money;

    /**
     * Метод, для получения к балансу счета
     * @return money - баланс счета
     */
    public static double getMoney() {
        return money;
    }

    /**
     * Метод, для изменения баланса счета
     * @param changeMoney - число, на которое нужно изменить баланс счета
     */
    @MinFund
    public static void setMoney(double changeMoney) throws NegativeAccountBalanceException {
        if (money + changeMoney < 0) {
            throw new NegativeAccountBalanceException("Для проведения операции не достаточно средств на счете!");
        }
        Accounting.money += changeMoney;
    }
}

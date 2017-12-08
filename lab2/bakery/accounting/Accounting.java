package lab2.bakery.accounting;

import lab2.bakery.exception.NegativeAccountBalanceException;

public class Accounting {

    private static double money;

    public Accounting(double money) throws NegativeAccountBalanceException {
        if (money < 0) {
            throw new NegativeAccountBalanceException("Баланс счета не может быть отрицательным!");
        }
        Accounting.money = money;
    }

    public double getMoney() {
        return money;
    }

    public static void setMoney(double changeMoney) throws NegativeAccountBalanceException {
        if (money + changeMoney < 0) {
            throw new NegativeAccountBalanceException("Для проведения операции не достаточно средств на счете!");
        }
        Accounting.money += changeMoney;
    }
}

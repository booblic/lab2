package lab2.bakery.accounting;

import lab2.bakery.exception.NegativeAccountBalanceException;

import lab2.bakery.annotation.MinFund;

public class Accounting {

    private static double money;

    public static double getMoney() {
        return money;
    }

    @MinFund
    public static void setMoney(double changeMoney) throws NegativeAccountBalanceException {
        if (money + changeMoney < 0) {
            throw new NegativeAccountBalanceException("Для проведения операции не достаточно средств на счете!");
        }
        Accounting.money += changeMoney;
    }
}

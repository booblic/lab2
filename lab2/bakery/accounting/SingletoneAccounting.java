/*package lab2.bakery.accounting;

import lab2.bakery.exception.NegativeAccountBalanceException;

public class SingletoneAccounting {

    private static Accounting accounting;

    private SingletoneAccounting() {}

    public static Accounting getAccounting() {
        return accounting;
    }

    public static Accounting getAccounting(double money) throws NegativeAccountBalanceException {
        if (accounting == null) {
            accounting = new Accounting(money);
        } else {
            accounting.setMoney(money);
        }
        return accounting;
    }

}*/

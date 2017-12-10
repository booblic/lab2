package lab2.bakery.menu;

import lab2.bakery.accounting.Accounting;
import lab2.bakery.annotation.DefaultPrice;
import lab2.bakery.exception.NegativeAccountBalanceException;
import lab2.bakery.exception.NegativeProductsQuantityException;
import lab2.bakery.products.Bread;
import lab2.bakery.products.Products;
import lab2.bakery.products.SingletonProducts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;


public class SellProducts extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public SellProducts(String input) {
        super(input);
    }

    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isExit = false;

        while(!isExit) {

            System.out.println("\n\nПодажа готовой продукции\n1) Продать хлеб\n2) Вернуться назад");

            String line = null;

            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int choice = Integer.parseInt(line);

            switch (choice) {
                case 1:

                    try {

                        Bread bread = SingletonProducts.getBread();

                        System.out.println("Для продажи доступно: " + bread.getQuantity()+ " буханок хлеба");

                        System.out.println("Введитье количество буханок, для продажи: ");

                        line = reader.readLine();
                        int quantity = Integer.parseInt(line);

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        if (bread.getPrice() == 0) {
                            System.out.println("Введитье цену одной буханки: ");
                            line = reader.readLine();

                            double price = Double.parseDouble(line);

                            if (price < 0) {
                                throw new NumberFormatException();
                            }

                            bread.setPrice(price);
                        }

                        Bread.setQuantity(-quantity);
                        Accounting.setMoney(quantity * bread.getPrice());
                        //getAccounting(quantity * bread.getPrice());

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод!");
                    } catch (NegativeProductsQuantityException e) {
                        e.getMessage();
                        return;
                    } catch (NegativeAccountBalanceException e) {
                        e.getMessage();
                        return;
                    }

                    System.out.println("Текущий баланс счет: " + Accounting.getMoney());

                    break;
                case 2:
                    isExit = true;
                    break;
            }
        }

    }
}

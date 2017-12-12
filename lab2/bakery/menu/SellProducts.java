package lab2.bakery.menu;

import lab2.bakery.accounting.Accounting;
import lab2.bakery.constants.Constants;
import lab2.bakery.exception.NegativeAccountBalanceException;
import lab2.bakery.exception.NegativeProductsQuantityException;
import lab2.bakery.products.SingletonProducts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Кирилл
 * @version 1.0
 * Класс для продажи готовой продукции
 */
public class SellProducts extends MenuEntry {
    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     * @param input - заглавие мпункта меню
     */
    public SellProducts(String input) {
        super(input);
    }

    /**
     * Метод, содержащий алгоритм для продажи готовой продукции
     */
    public void go() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isExit = false;

        while(!isExit) {

            System.out.println("\n\nПодажа готовой продукции\n1) Продать хлеб\n2) Вернуться назад");

            String line = null;
            int choice = 0;

            try {
                line = reader.readLine();
                choice = Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_INPUT);
                return;
            }

            switch (choice) {
                case 1:

                    try {

                        System.out.println("Для продажи доступно: " + SingletonProducts.getBread().getQuantity()+ " буханок хлеба");

                        System.out.println("Введитье количество буханок, для продажи: ");

                        line = reader.readLine();
                        int quantity = Integer.parseInt(line);

                        if (quantity < 0) {
                            System.out.println(Constants.INVALID_INPUT);
                            break;
                        }

                        if (SingletonProducts.getBread().getPrice() == 0) {
                            System.out.println("Введитье цену одной буханки: ");
                            line = reader.readLine();

                            double price = Double.parseDouble(line);

                            if (price < 0) {
                                throw new NumberFormatException();
                            }

                            SingletonProducts.getBread().setPrice(price);
                        }

                        SingletonProducts.getBread().setQuantity(-quantity);
                        Accounting.setMoney(quantity * SingletonProducts.getBread().getPrice());

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println(Constants.INVALID_INPUT);
                    } catch (NegativeProductsQuantityException e) {
                        System.out.println(e.getMessage());
                    } catch (NegativeAccountBalanceException e) {
                        System.out.println(e.getMessage());
                        return;
                    }

                    System.out.println("Текущий баланс счет: " + Accounting.getMoney());

                    break;
                case 2:
                    isExit = true;
                    break;
                default:
                        System.out.println(Constants.INVALID_INPUT);
            }
        }

    }
}

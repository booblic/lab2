package lab2.bakery.main;

import lab2.bakery.menu.Menu;

/**
 * Класс с методом main для запуска программы
 * @author Кирилл
 * @version 1.0
 */
public class Main {

    /**
     * Метод с которого начиается выполнение программы
     * @param args - агрумент из командной строки
     */
    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.go();
    }
}

package lab2.bakery.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lab2.bakery.constant.ClassOfConstant;

/**
 * Класс для работы с меню
 * @author Кирилл
 * @version 1.0
 */
public class Menu {

    /**
     * Коллекция для хранения пунктов меню
     */
    private static List<MenuEntry> entries = new ArrayList<>();

    /**
     * Флаг для выхода из меню
     */
    private boolean isExit = false;

    /**
     * Конструктор создающий пункты меню
     */
    public Menu() {

        entries.add(new MenuEntry("Выход.") {
            public void run() {
                isExit = true;
            }
        });

        addEntry(new CreateBakery("Создасть хлебзавод."));

    }

    /**
     * Метод отображающий меню в консоле, считывающий номер пункта меню с клавиатуры и запускающий выполнение соответствующего пункта
     */
    public void run() {

        while (!isExit) {

            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                MenuEntry entry = entries.get(choice - 1);
                entry.run();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод!");
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка!");
            }

        }
    }

    /**
     * Метод для добавления пункта меню в коллекцию
     * @return объект класса производный от абстактного класса MenuEntry, соответствующий пункту меню
     */
    public static void addEntry(MenuEntry entry) {

        for (int i = 0; i < entries.size(); i++) {

            MenuEntry entryExist = entries.get(i);

            if (entryExist.title.compareTo(entry.title) == 0) {
                return;
            }
        }

        int index = entries.size() - 1;
        entries.add(index, entry);
    }

    public static void deleteEntry(String title) {
        for (int i = 0; i < entries.size(); i++) {

            MenuEntry entry = entries.get(i);

            if (entry.title.compareTo(title) == 0) {
                entries.remove(i);
            }
        }
    }

    /**
     * Метод извлекает из коллекции объекты соответствующие пунктам меню и выводит их заглавие на консоль
     */
    private void printMenu() {

        StringBuffer buffer = new StringBuffer();
        buffer.append("\nХлебзавод:\n");

        for (int i = 0; i < entries.size(); i++) {

            MenuEntry entry = entries.get(i);
            String entryFormatted = String.format(ClassOfConstant.MENU_PATTERN, (i + 1), entry.getTitle());
            buffer.append(entryFormatted);
        }
        System.out.print(buffer.toString());
    }
}


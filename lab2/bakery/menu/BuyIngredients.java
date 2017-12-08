package lab2.bakery.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import lab2.bakery.accounting.SingletoneAccounting;
import lab2.bakery.exception.NegativeAccountBalanceException;
import lab2.bakery.exception.NegativeIngredientsQuantityException;
import lab2.bakery.ingredients.SingletoneIngredients;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static lab2.bakery.accounting.SingletoneAccounting.*;
import static lab2.bakery.ingredients.SingletoneIngredients.*;

/**
 * Класс для первого пункта меню, соответсвующему считыванию выражения из файла
 * @author Кирилл
 * @version 1.0
 */
public class BuyIngredients extends MenuEntry {

    private double money;

    /**
     * Конструктор вызывающий конструктор базового (абстрактного) класса
     *
     * @param input - заглавие мпункта меню
     */
    public BuyIngredients(String input) {
        super(input);
    }

    /**
     * Метод содержащий последовательнсть действий пункта меню
     */
    public void run() {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filepath = "PriceList.xml";

        File xmlFile = new File(filepath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            NodeList unitPrices = document.getElementsByTagName("Стоимость");
            NodeList unitQuantitys = document.getElementsByTagName("Количество");

            for (int i = 0; i < unitPrices.getLength(); i++) {

                int quantity;

                Node name = unitPrices.item(i).getParentNode();

                switch (name.getNodeName()) {

                    case "Мука":
                        System.out.println("Стоимость одного килограмма муки: " + unitPrices.item(i).getTextContent() + " руб.");
                        System.out.print("Введите количество килограммов муки для закупки: ");

                        quantity = Integer.parseInt(reader.readLine());

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        getAccounting(-Double.parseDouble(unitPrices.item(i).getTextContent()) * quantity);

                        getFlour(Double.parseDouble(unitPrices.item(i).getTextContent()), quantity);

                        break;

                    case "Вода":
                        System.out.println("Стоимость одного литра воды: " + unitPrices.item(i).getTextContent() + " руб.");
                        System.out.print("Введите количество литров воды для закупки: ");

                        quantity = Integer.parseInt(reader.readLine());

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        getAccounting(-Double.parseDouble(unitPrices.item(i).getTextContent()) * quantity);

                        getWater(Double.parseDouble(unitPrices.item(i).getTextContent()), quantity);

                        break;

                    case "Соль":
                        System.out.println("Стоимость одного килограмма соли: " + unitPrices.item(i).getTextContent() + " руб.");
                        System.out.print("Введите количество килограммов соли для закупки: ");

                        quantity = Integer.parseInt(reader.readLine());

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        getAccounting(-Double.parseDouble(unitPrices.item(i).getTextContent()) * quantity);

                        getSalt(Double.parseDouble(unitPrices.item(i).getTextContent()), quantity);

                        break;

                    case "Масло_растительное":
                        System.out.println("Стоимость одной литра растительного масла: " + unitPrices.item(i).getTextContent() + " руб.");
                        System.out.print("Введите количество литров растительного масла для закупки: ");

                        quantity = Integer.parseInt(reader.readLine());

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        getAccounting(-Double.parseDouble(unitPrices.item(i).getTextContent()) * quantity);

                        getVegetableOil(Double.parseDouble(unitPrices.item(i).getTextContent()), quantity);

                        break;

                    case "Дрожжи":
                        System.out.println("Стоимосить одного килограмма дрожжей: " + unitPrices.item(i).getTextContent() + " руб.");
                        System.out.print("Введите количество килограммов дрожжей для закупки: ");

                        quantity = Integer.parseInt(reader.readLine());

                        if (quantity < 0) {
                            throw new NumberFormatException();
                        }

                        getAccounting(-Double.parseDouble(unitPrices.item(i).getTextContent()) * quantity);

                        getYeast(Double.parseDouble(unitPrices.item(i).getTextContent()), quantity);

                        break;
                }

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NegativeAccountBalanceException e) {
            System.out.println(e.getMessage());
            return;
        } catch (NegativeIngredientsQuantityException e) {
            e.printStackTrace();
        }

        Menu.addEntry(new ShowIngredients("Посмотреть количество ингредиентов."));

        Menu.addEntry(new BreadCreator("Испечь хлеб"));

    }
}

package bl;

import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBl {
    // wird im Konstruktor initialisiert
    private Scanner scanner;
    // Datentyp der Elemente in der Liste ist Generics <Order>;
    private List<Order> orderList = new ArrayList<>();

    public OrderBl(Scanner scanner) {
        this.scanner = scanner;
    }

    public void toUser() {
        // Objekt vom OrderBl erstellen und den Scanner mitgeben
        OrderBl orderBl = new OrderBl(scanner);
        int userInput;
        // Hauptmenü User;
        System.out.println("---DeliveryServiceManager User---");
        while (true) {
            System.out.printf("%s\n%s\n%s\n", "Hallo! Was möchten Sie tun?"
                    , "Etwas bestellen--> 1", "Programm beenden--> 2");
            String userChoice = scanner.nextLine();
            while (!(userChoice.equals("1") || userChoice.equals("2"))) {
                System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                userChoice = scanner.nextLine();
            }
            userInput = Integer.parseInt(userChoice);
            switch (userInput) {
                case 1:
                    orderBl.addOrder();
                    break;
                case 2:
                    System.out.println("Sie haben das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                    break;
            }
        }

    }

    // Bestellung erstellen;
    public void addOrder() {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n", "Guten Tag!", "Was möchten Sie bestellen?"
                , "Pizza!", "Burger!", "Hotdog");
        String mealName = scanner.nextLine();
        if(!(mealName.equalsIgnoreCase("Pizza")||mealName.equalsIgnoreCase("Burger")||
                mealName.equalsIgnoreCase("Hotdog"))){
            System.out.println("ACHTUNG: Ihre eingabe würde nicht erkannt!");
        }
        System.out.println("Bitte den Stückzahl angeben!");
        if (!scanner.hasNextInt()) {
            System.out.println("Bitte eine gültige Zahl eingeben!");
            scanner.next(); // clear input stream buffer
        }
        int numberOfMeals = scanner.nextInt();
        System.out.println("Sie haben " + numberOfMeals + " " + mealName + " bestellt");
        System.out.println("Wollen Sie fortfahren? (Ja // Nein)");
        String answer = scanner.nextLine();
        if (answer.equals("Nein")) {
            System.out.println("Sie haben das Programm beendet");
            System.out.println("Bis zum nächsten mal!");
            System.exit(0);
        } else {
            Order order = new Order(mealName, numberOfMeals);
            orderList.add(order);
            listOrder();
        }

    }

    // Liste der Bestellungen auslesen;
    public void listOrder() {
        for (Order order : orderList) {
            printOrder(order);
        }
    }

    public void printOrder(Order order) {
        System.out.println("Sie haben " + order.getNumberOfMeals() + " " + order.getMealName()
                + " bestellt!");
    }

}

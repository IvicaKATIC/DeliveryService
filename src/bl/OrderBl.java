package bl;

import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Für den User um etwas zu bestellen;
public class OrderBl {
    private static final Scanner scanner = new Scanner(System.in);
    // Datentyp der Elemente in der Liste ist Generics <Order>;
    private final List<Order> orderList = new ArrayList<>();

    public void toUser() {
        // Objekt vom OrderBl erstellen;
        OrderBl orderBl = new OrderBl();
        // Hauptmenü User;
        System.out.println("---DeliveryServiceManager User---");
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Hallo! Was möchten Sie tun?"
                    , "Etwas bestellen--> 1", "Liste der Bestellungen sehen--> 2", "Programm beenden--> 3");
            String userChoice = scanner.nextLine();
            while (!(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3"))) {
                System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                System.out.println("Wählen Sie bitte zwischen 1 , 2 oder 3!");
                scanner.nextLine();
            }
            int userInput = Integer.parseInt(userChoice);
            switch (userInput) {
                case 1:
                    orderBl.addOrder();
                    break;
                case 2:
                    orderBl.listOrder();
                    break;
                case 3:
                    System.out.println("Sie haben das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: Ihre Eingabe würde nicht erkannt!");
                    break;
            }
        }

    }

    // Bestellung erstellen;
    public void addOrder() {
        System.out.println("---Ihre Bestellung---");
        String orderName = getOrderName();
        int numberOfMeals = getNumberOfMeals();
        Order order = new Order(orderName, numberOfMeals);
        orderList.add(order);
        System.out.println("Die Bestellung wurde hinzugefügt!");
        System.out.println("Wollen Sie fortfahren? (Ja // Nein)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Nein")) {
            System.out.println("Sie haben das Programm beendet!");
            System.out.println("Bis zum nächsten mal!");
            System.exit(0);
        } else {
            System.out.println("Wollen Sie noch was bestellen?(Ja // Nein");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Nein")) {
                listOrder();
            }
        }
    }
    // ERROR!!!! Die Methode wiederholt sich;
    private String getOrderName() {
        boolean correctInput = false;
        String orderName = null;
        while (!correctInput) {
            System.out.println("Was möchten Sie bestellen?");
            System.out.println("Pizza, Burger oder Hotdog?");
            orderName = scanner.nextLine();
            if (!(orderName.equalsIgnoreCase("Pizza") || orderName.equalsIgnoreCase("Burger") ||
                    orderName.equalsIgnoreCase("Hotdog"))) {
                System.out.println("ERROR: Ihre eingabe wurde nicht erkannt!Wählen Sie bitte zwischen Pizza, Burger oder Hotdog!");
            } else correctInput = true;
        }
        return orderName;
    }

    private int getNumberOfMeals() {
        boolean correctInput = false;
        String numberOfMeals = null;
        while (!correctInput) {
            System.out.println("Wieviele " + getOrderName() + " wollen Sie bestellen?:");
            numberOfMeals = scanner.nextLine();
            if (!Character.isDigit(numberOfMeals.charAt(0))) {
                System.out.println("ERROR: Geben Sie bitte eine Zahl ein!");
            } else if (numberOfMeals.contains(",")) {
                System.out.println("ERROR: Bitte den Punkt statt Koma verwenden!");
            } else correctInput = true;
        }
        return Integer.parseInt(numberOfMeals);
    }


    // Liste der Bestellungen auslesen;
    public void listOrder() {
        for (Order order : orderList) {
            printOrder(order);
        }
    }

    // Bestellungen ausgeben;
    public void printOrder(Order order) {
        System.out.println("Sie haben " + order.getNumberOfMeals() + " " + order.getOrderName()
                + " bestellt!");
    }

}

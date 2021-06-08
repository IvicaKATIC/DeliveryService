package bl;

import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// For the user to order something;
public class OrderBl {
    private static final Scanner scanner = new Scanner(System.in);
    // Datentyp der Elemente in der Liste ist Generics <Order>;
    private final List<Order> orderList = new ArrayList<>();

    public void toUser() {
        // Objekt vom OrderBl erstellen;
        OrderBl orderBl = new OrderBl();
        // Main menu user;
        System.out.println("---DeliveryServiceManager User---");
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Hallo! Was möchten Sie tun?"
                    , "Etwas bestellen--> 1", "Liste der Bestellungen sehen--> 2", "Programm beenden--> 3");
            String userChoice = scanner.nextLine();
            while (!(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3"))) {
                System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                System.out.println("Wählen Sie bitte zwischen 1 , 2 oder 3!");
                userChoice = scanner.next();
            }
            switch (userChoice) {
                case "1":
                    orderBl.addOrder();
                    break;
                case "2":
                    orderBl.listOrder();
                    break;
                case "3":
                    System.out.println("Sie haben das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: Ihre Eingabe würde nicht erkannt!");
                    break;
            }
        }

    }

    // Create Order;
    public void addOrder() {
        System.out.println("---Ihre Bestellung---");
        String orderName = getNameOfOrder();
        System.out.println("Wie viele " + orderName + " wollen Sie bestellen?:");
        int numberOfMeals = getNumberOfMeals();
        Order order = new Order(orderName, numberOfMeals);
        orderList.add(order);
        System.out.println("Die Bestellung wurde hinzugefügt!");
        System.out.println("Wollen Sie noch was bestellen?");
        System.out.println("(Bitte Ja oder Nein eintippen!)");
        String answer = scanner.nextLine();
        if (!(answer.equalsIgnoreCase("Ja") || answer.equalsIgnoreCase("Nein"))) {
            System.out.println("ERROR: Wählen Sie bitte zwischen Ja oder Nein!:");
            scanner.nextLine();
        } else if (answer.equalsIgnoreCase("Nein")) {
            listOrder();
        } else {
            addOrder();
        }
    }

    private String getNameOfOrder() {
        boolean correctInput = false;
        String orderName = null;
        while (!correctInput) {
            System.out.println("Was möchten Sie bestellen?");
            System.out.println("Pizza, Burger oder Hotdog?");
            orderName = scanner.nextLine();
            if (!(orderName.equalsIgnoreCase("Pizza") || orderName.equalsIgnoreCase("Burger") ||
                    orderName.equalsIgnoreCase("Hotdog"))) {
                System.out.println("ERROR: Ihre Eingabe wurde nicht erkannt!");
                System.out.println("Wählen Sie bitte zwischen Pizza, Burger oder Hotdog!");
            } else correctInput = true;
        }
        return orderName;
    }

    private int getNumberOfMeals() {
        boolean correctInput = false;
        String numberOfMeals = null;
        while (!correctInput) {
            numberOfMeals = scanner.nextLine();
            if (numberOfMeals.length() >= 1) {
                if (!Character.isDigit(numberOfMeals.charAt(0))) {
                    System.out.println("ERROR: Bitte eine Zahl eingeben!");
                } else if (numberOfMeals.contains(",") || numberOfMeals.contains(".")) {
                    System.out.println("ERROR: Sie müssen eine runde Zahl eingeben!");
                } else correctInput = true;
            }
        }
        return Integer.parseInt(numberOfMeals);
    }


    // read out the list of orders;
    public void listOrder() {
        // The warning if the list is empty is written about it;
        if (orderList.isEmpty()) {
            System.out.println("ACHTUNG: Ihre Liste der Bestellungen ist leer!");
        }
        for (Order order : orderList) {
            printOrder(order);
        }
    }

    // Issue orders;
    public void printOrder(Order order) {
        System.out.println("Sie haben " + order.getNumberOfMeals() + " " + order.getOrderName()
                + " bestellt!");
    }

}

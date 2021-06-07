package bl;

import model.CreateJunkFood;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// für den Admin um JunkFood zu erstellen;
public class CreateJunkFoodBl {
    private static final Scanner scanner = new Scanner(System.in);
    // Datentyp der Elemente in der Liste ist Generics <CreateJunkFood>;
    private final List<CreateJunkFood> foodList = new ArrayList<>();

    public void toAdmin() {
        // Objekt vom CreateJunkFoodBl erzeugen
        CreateJunkFoodBl createJunkFoodBl = new CreateJunkFoodBl();
        // Hauptmenü Administrator;
        System.out.println("---DeliveryServiceManager Admin---");
        // zuerst das Passwort abfragen;
        checkPassword();
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Hallo Admin! Was willst du tun?"
                    , "JunkFood erstellen--> 1", "JunkFood Liste ausgeben--> 2", "Programm beenden--> 3");
            String adminChoice = scanner.nextLine();
            while (!(adminChoice.equals("1") || adminChoice.equals("2") || adminChoice.equals("3"))) {
                System.out.println("ERROR: Deine Angabe wurde nicht erkannt!");
                System.out.println("Wähle bitte zwischen 1, 2 oder 3!");
                adminChoice = scanner.nextLine();
            }
            switch (adminChoice) {
                case "1":
                    createJunkFoodBl.addCreateJunkFoodBl();
                    break;
                case "2":
                    createJunkFoodBl.listCreateJunkFoodBl();
                    break;
                case "3":
                    System.out.println("Du hast das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: Deine Angabe wurde nicht erkannt!");
                    break;
            }
        }
    }


    // JunkFood erstellen;
    public void addCreateJunkFoodBl() {
        System.out.println("---JunkFood erstellen---");
        String mealName = getMealName();
        double basePrice = getBasePrice();
        int ingredientsNumber = getIngredientsNumber();
        double pricePerIngredient = getPricePerIngredient();
        CreateJunkFood createJunkFood = new CreateJunkFood(mealName, basePrice, ingredientsNumber, pricePerIngredient);
        foodList.add(createJunkFood);
        System.out.println("JunkFood würde hinzugefügt!");
        System.out.println();
    }


    private String getMealName() {
        boolean correctInput = false;
        String mealName = null;
        while (!correctInput) {
            System.out.println("Name des Gerichtes?:");
            mealName = scanner.nextLine();
            if (mealName.isEmpty()) {
                System.out.println("ERROR: Du musst einen Namen eingeben!");
                mealName = scanner.nextLine();
            } else correctInput = true;
        }
        return mealName;
    }

    private double getBasePrice() {
        boolean correctInput = false;
        String basePrice = null;
        while (!correctInput) {
            System.out.println("Grundpreis?:");
            basePrice = scanner.nextLine();
            if (basePrice.length() >= 1) {
                if (!Character.isDigit(basePrice.charAt(0))) {
                    System.out.println("ERROR: Bitte eine Zahl eingeben!");
                } else if (basePrice.contains(",")) {
                    System.out.println("ERROR: Bitte den Punkt statt Koma verwenden!");
                } else correctInput = true;
            }
        }
        return Double.parseDouble(basePrice);
    }

    private int getIngredientsNumber() {
        boolean correctInput = false;
        String ingredientsNumber = null;
        while (!correctInput) {
            System.out.println("Anzahl der Zutaten?:");
            ingredientsNumber = scanner.nextLine();
            if (ingredientsNumber.length() >= 1) {
                if (!Character.isDigit(ingredientsNumber.charAt(0))) {
                    System.out.println("ERROR: Bitte eine Zahl eingeben!!");
                } else if (ingredientsNumber.contains(",") || ingredientsNumber.contains(".")) {
                    System.out.println("ERROR: Es muss eine runde Zahl sein!");
                } else correctInput = true;
            }
        }
        return Integer.parseInt(ingredientsNumber);
    }

    private double getPricePerIngredient() {
        boolean correctInput = false;
        String pricePerIngredient = null;
        while (!correctInput) {
            System.out.println("Preis pro Zutate?:");
            pricePerIngredient = scanner.nextLine();
            if (pricePerIngredient.length() >= 1) {
                if (!Character.isDigit(pricePerIngredient.charAt(0))) {
                    System.out.println("ERROR: Bitte eine Zahl eingeben!");
                } else if (pricePerIngredient.contains(",")) {
                    System.out.println("ERROR: Bitte den Punkt statt Koma verwenden!");
                } else correctInput = true;
            }
        }
        return Double.parseDouble(pricePerIngredient);
    }


    // Preisliste auslesen;
    public void listCreateJunkFoodBl() {
        System.out.println();
        for (CreateJunkFood createJunkFood : foodList) {
            printCreateJunkFood(createJunkFood);
        }
    }

    // Das erzeugte JunkFood ausgeben;
    public void printCreateJunkFood(CreateJunkFood createJunkFood) {
        System.out.println("Name des Gerichtes: " + createJunkFood.getMealName() + ", Grundpreis: € " + createJunkFood.getBasePrice() +
                ", Anzahl der Zutaten: " + createJunkFood.getIngredientsNumber() + ", Preis per Zutate: € " + createJunkFood.getPricePerIngredient() +
                ", Preis des Gerichtes: € " + createJunkFood.getTotalPrice());
    }

    // Um das Passwort zu überprüfen (in diesem Fall "deliveryservice");
    public void checkPassword() {
        String password;
        int i = 1;
        System.out.println("Hallo Admin! Gib bitte das Passwort ein!");
        System.out.println("(ACHTUNG: Du hast 3 Versuche):");
        password = scanner.nextLine();
        while (!password.equalsIgnoreCase("DeliveryService") && i < 3) {
            System.out.println("ERROR: PASSWORT FALLSCH: NEUER VERSUCH!");
            password = scanner.nextLine();
            i++;
        }
        if (password.equalsIgnoreCase("DeliveryService")) {
            System.out.println("Zugang gewährt!");
        } else {
            System.out.println("ERROR: Zu viele Versuche! ZUGANG VERWEIGERT!");
            System.out.println("Wende dich an den System-Administrator!");
            System.exit(0);
        }
    }
}

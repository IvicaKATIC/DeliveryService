package bl;

import model.CreateJunkFood;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// für den Admin um JunkFood zu erstellen;
public class CreateJunkFoodBl {
    private Scanner scanner; // wird über Konstruktor initialisiert;
    // Datentyp der Elemente in der Liste ist Generics <CreateJunkFood>;
    private List<CreateJunkFood> foodList = new ArrayList<>();

    public CreateJunkFoodBl(Scanner scanner) {
        this.scanner = scanner;
    }


    public void toAdmin() {
        // Objekt vom CreateJunkFoodBl erzeugen und den Scanner mitgeben;
        CreateJunkFoodBl createJunkFoodBl = new CreateJunkFoodBl(scanner);
        // Hauptmenü Administrator;
        System.out.println("---DeliveryServiceManager Admin---");
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Hallo Admin! Was willst du tun?"
                    , "JunkFood erstellen--> 1", "JunkFood Liste ausgeben--> 2", "Programm beenden--> 3");
            String adminChoice = scanner.nextLine();
            while (!(adminChoice.equals("1") || adminChoice.equals("2") || adminChoice.equals("3"))) {
                System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
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
                    System.out.println("Sie haben das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                    break;
            }
        }
    }


    // JunkFood erstellen;
    public void addCreateJunkFoodBl() {
        System.out.println("Name des Gerichts:");
        if (!scanner.hasNextLine()) {
            System.out.println("ACHTUNG: Ihre eingabe würde nicht erkannt!");
            scanner.next();// clear input stream buffer
        }
        String mealName = scanner.nextLine();
        System.out.println("Grundpreis:");
        if (!scanner.hasNextDouble()) {
            System.out.println("FEHLER: Bitte einen gültigen Preis eingeben!");
            scanner.next();// clear input stream buffer
        }
        double basePrice = scanner.nextDouble();
        System.out.println("Anzahl der Zutaten:");
        if (!scanner.hasNextDouble()) {
            System.out.println("FEHLER: Bitte einen gültigen Preis eingeben!");
            scanner.next(); // clear input stream buffer
        }
        int ingredientsNumber = scanner.nextInt();
        System.out.println("Preis pro Zutate:");
        if (!scanner.hasNextDouble()) {
            System.out.println("FEHLER: Bitte einen gültigen Preis eingeben!");
            scanner.next(); // clear input stream buffer
        }
        double pricePerIngredient = scanner.nextDouble();
        CreateJunkFood createJunkFood = new CreateJunkFood(mealName, basePrice, ingredientsNumber, pricePerIngredient);
        foodList.add(createJunkFood);
        System.out.println("JunkFood würde hinzugefügt!");
    }

    // Preisliste auslesen;
    public void listCreateJunkFoodBl() {
        for (CreateJunkFood createJunkFood : foodList) {
            printCreateJunkFood(createJunkFood);
        }
    }

    public void printCreateJunkFood(CreateJunkFood createJunkFood) {
        System.out.println("JunkFood Name: " + createJunkFood.getMealName() +
                ", Preis: € " + createJunkFood.getTotalPrice());
    }
}

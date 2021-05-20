import bl.CreateJunkFoodBl;
import bl.OrderBl;

import java.util.Scanner;

public class DSManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CreateJunkFoodBl junkFoodBl = new CreateJunkFoodBl();
        OrderBl orderBl = new OrderBl();
        System.out.println("-----Main Menu-----");
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Guten Tag!", "Wenn Sie der Administrator sind--> 1!"
                    , "Wenn Sie der Kunde sind--> 2!", "Um das Programm zu beenden--> 3!");
            String useCase = scanner.nextLine();
            while (!(useCase.equals("1") || useCase.equals("2") || useCase.equals("3"))) {
                System.out.println("ERROR: Ihre Eingabe wurde nicht erkannt!");
                System.out.println("Wählen Sie bitte zwischen 1, 2 oder 3!");
                useCase = scanner.nextLine();
            }

            switch (useCase) {
                case "1":
                    junkFoodBl.toAdmin();
                    break;
                case "2":
                    orderBl.toUser();
                    break;
                case "3":
                    System.out.println("Sie haben das Programm beendet!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: Ihre Eingabe wurde nicht erkannt!");
                    break;
            }

        }
    }

}



import bl.CreateJunkFoodBl;
import bl.OrderBl;

import java.util.Scanner;

public class DSManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateJunkFoodBl junkFoodBl = new CreateJunkFoodBl(scanner);
        OrderBl orderBl = new OrderBl(scanner);
        System.out.println("-----Main Menu-----");
        while (true) {
            System.out.printf("%s\n%s\n%s\n%s\n", "Guten Tag!", "Wenn Sie der Administrator sind--> 1!"
                    , "Wenn Sie der Kunde sind--> 2!", "Um das Programm zu beenden--> 3!");
            String useCase = scanner.nextLine();
            while (!(useCase.equals("1") || useCase.equals("2") || useCase.equals("3"))) {
                System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
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
                    System.out.println("ACHTUNG: Ihre Eingabe würde nicht erkannt!");
                    break;
            }

        }
    }
}



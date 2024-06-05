package menu;

import exceptions.*;
import order.OrderStructure;

import java.util.Scanner;

import static java.lang.System.exit;

public class MenuStructure {
    private static Scanner sc = new Scanner(System.in);
    private static String option;
    public static void menuStructure(){
        do{
            try{
                UI.mainMenu();
                option = sc.nextLine();

                switch (option){
                    case "1":
                        OrderStructure.newOrder();
                        break;
                    case "2":
                        OrderStructure.deliveredOrder();
                        break;
                    case"3":
                        OrderStructure.listOrders();
                        break;
                    case"4":
                        OrderStructure.listDeliveredOrders();
                        break;
                    case"5":
                        exitProgram();
                    default:
                        throw new InvalidMenuOptionException();
                }
            } catch (InvalidMenuOptionException | CustomerUndefinedException | NoAvailableRider | EmptyProductListException | IDundefined | NullPointerException e) {
                printError(e.getMessage());
            } catch (NumberFormatException e) {
                printError("ERR " + e.getMessage());
            }
        } while (!option.equals("5"));

    }
    private static void printError(String message) {
        System.out.println("Error: " + message);
    }
    private static void exitProgram() {
        System.out.println("Exiting...");
        sc.close();
        exit(0);
    }
}

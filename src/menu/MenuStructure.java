package menu;

import exceptions.*;
import order.OrderStructure;

import java.util.Scanner;

import static java.lang.System.exit;
import static menu.option.MainMenuOption.*;

public class MenuStructure {
    private static Scanner sc = new Scanner(System.in);
    private static String option;
    public static void menuStructure(){
        do{
            try{
                UI.mainMenu();
                option = sc.nextLine();

                switch (Integer.parseInt(option)){
                    case NEWORDER -> OrderStructure.newOrder();

                    case CONFIRMORDERHASBENNDELIVERED -> OrderStructure.deliveredOrder();

                    case LISTPENDINGORDERS -> OrderStructure.listOrders();

                    case LISTDELIVEREDORDERS -> OrderStructure.listDeliveredOrders();

                    case EXIT -> exitProgram();
                    default -> throw new InvalidMenuOptionException();
                }
            } catch (InvalidMenuOptionException | CustomerUndefinedException | NoAvailableRider | EmptyProductListException | IDundefined | NullPointerException e) {
                printError(e.getMessage());
            } catch (NumberFormatException e) {
                printError("ERR " + e.getMessage());
            }
        } while (true);

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

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
                        exit(0);
                    default:
                        throw new InvalidMenuOptionException();
                }
            }catch(InvalidMenuOptionException e){
                System.out.println(e.getMessage());
            }catch(CustomerUndefinedException e){
                System.out.println(e.getMessage());
            }catch(NoAvailableRider e){
                System.out.println(e.getMessage());
            }catch(NumberFormatException e){
                System.out.println("ERR"+e.getMessage());
            }catch(EmptyProductListException e){
                System.out.println(e.getMessage());
            }catch(IDundefined e){
                System.out.println(e.getMessage());
            }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
        } while(!option.equals(5));
    }
}

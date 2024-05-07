package order;

import exceptions.*;
import menu.UI;
import people.Customer;
import people.Rider;
import products.*;
import speed.Speed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderStructure {
    private static Scanner sc = new Scanner(System.in);
    private static String option;
    private static Random random = new Random();

    private static Customer c1 = new Customer("antonio", "avinguda1");
    private static Customer c2 = new Customer("antonio2", "avinguda2");
    private static Customer c3 = new Customer("antonio3", "avinguda3");
    private static Customer c4 = new Customer("antonio4", "avinguda4");

    private static Rider r1 = new Rider("r1_Jordy");
    private static Rider r2 = new Rider("r2_Jorge");
    private static Rider r3 = new Rider("r3_Maria");

    private static List<Customer> customers = List.of(c1,c2,c3,c4);
    private static List<Rider> riders = List.of(r1,r2,r3);
    private static List<Order> orders = new ArrayList<>();
    private static List<Order> deliveredOrders = new ArrayList<>();


    //order create

    public static void newOrder()throws CustomerUndefinedException, EmptyProductListException, IDundefined, InvalidMenuOptionException, NoAvailableRider{
        Rider rider;
        Customer customer;
        List<Products> products;
        Speed speed;

        customer = pickCustomer();
        products = pickProductList();
        rider = pickRider();
        speed = pickSpeed();

        Order order = new Order(customer, rider, products,speed);
        orders.add(order);
        System.out.println("Order completed!");
    }

        private static Customer pickCustomer()throws CustomerUndefinedException{
        String name;
            UI.customerMenu();
            name=sc.nextLine();
            for (Customer customer : customers){
                if(customer.getName().equals(name)){
                    return customer;
                }
            }
            throw new CustomerUndefinedException();
        }

        private static Rider pickRider()throws  NoAvailableRider{
        if(riders.stream().allMatch(rider -> !rider.isAvailable())){
            throw new NoAvailableRider();
        }
        int randomIndex = random.nextInt(riders.size());
        boolean free = false;

        do{
            if(riders.get(randomIndex).isAvailable()){
                free = true;
                riders.get(randomIndex).setAvailable(false);
                return riders.get(randomIndex);
            }
            randomIndex = random.nextInt(riders.size());
        } while(!free);
        return null;

        }

        //speed
    private static Speed pickSpeed() throws  InvalidMenuOptionException{
        UI.speedMenu();
        option = sc.nextLine();
        switch (option){
            case "2":
                return new Speed(false,true,false);
            case "3":
                return new Speed(false,false,true);
            case "1":
                return new Speed(true,false,false);
            default:
                throw new InvalidMenuOptionException();
        }
    }

    private static List<Products> pickProductList()throws InvalidMenuOptionException, EmptyProductListException{
        List<Products> products = new ArrayList<Products>();

        do{
            UI.productsListMenu();
            option = sc.nextLine();
            switch (option){
                case "1":
                    products.add(pickProduct());
                    option="";
                    break;
                case "2":
                    break;
                default:
                    throw new InvalidMenuOptionException();
            }
             } while (!option.equals("2"));
            if(products.isEmpty()){
                throw new EmptyProductListException();
            }
            return products;
    }

    private static Products pickProduct() throws  InvalidMenuOptionException{
        UI.productsMenu();
        option = sc.nextLine();
        switch (option){
            case "1":
                return new Burritos();
            case "2":
                return new Hamburger();
            case "3":
                return new Kebab();
            case "4":
                return new Pizza();
            default:
                throw new InvalidMenuOptionException();
        }
    }

    // Delivery

    public static void deliveredOrder() throws  NumberFormatException, IDundefined, NullPointerException{
        int id;
        Order o;

        UI.deliveryMenu();
        id= Integer.parseInt(sc.nextLine());

        o= orders.stream()
                .filter(order -> order.getID()== id)
                .findFirst()
                .orElse(null);

        if(o==null) {
            throw new IDundefined();
        }
        o.getRider().setAvailable(true);
        orders.remove(o);
        deliveredOrders.add(o);
        System.out.println("Order successfully Delivered!");
    }

    // order List (Pending)

    public static void listOrders() {
        System.out.println("PENDING ORDERS");
        orders.forEach(order -> System.out.println(order));
    }

    // delivered orders

    public static void listDeliveredOrders(){
        System.out.println("ORDERS DELIVERED");
        deliveredOrders.forEach(order -> System.out.println(order));
    }

}

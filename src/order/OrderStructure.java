package order;

import exceptions.*;
import menu.UI;
import people.Customer;
import people.Rider;
import products.*;
import transport.*;
import transport.Transport;
import transport.TransportType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderStructure {
    private static final Scanner sc = new Scanner(System.in);
    private static String option;
    private static final Random random = new Random();

    private static final Customer c1 = new Customer("antonio", "avinguda1");
    private static final Customer c2 = new Customer("antonio2", "avinguda2");
    private static final Customer c3 = new Customer("antonio3", "avinguda3");
    private static final Customer c4 = new Customer("antonio4", "avinguda4");

    private static final Rider r1 = new Rider("r1_Jordy");
    private static final Rider r2 = new Rider("r2_Jorge");
    private static final Rider r3 = new Rider("r3_Maria");

    private static List<Customer> customers = List.of(c1,c2,c3,c4);
    private static List<Rider> riders = List.of(r1,r2,r3);
    private static List<Order> orders = new ArrayList<>();
    private static List<Order> deliveredOrders = new ArrayList<>();

    private static void listCustomers() {
        System.out.println("Available Customers:");
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    //order create

    public static void newOrder() throws CustomerUndefinedException, EmptyProductListException, IDundefined, InvalidMenuOptionException, NoAvailableRider {
        Customer customer = pickCustomer();
        List<Products> products = pickProductList();
        Rider rider = pickRider();
        TransportType transportType = pickTransport();

        double finalPrice = calculateFinalPrice(products, transportType);

        Order order = new Order(customer, rider, products, transportType, finalPrice);
        orders.add(order);
        System.out.println("Order completed!");
    }

    private static Customer pickCustomer() throws CustomerUndefinedException {
        listCustomers();
        UI.customerMenu();

        String name = sc.nextLine();

        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(CustomerUndefinedException::new);
    }

    private static Rider pickRider() throws NoAvailableRider {
        List<Rider> availableRiders = riders.stream()
                .filter(Rider::isAvailable)
                .collect(Collectors.toList());

        if (availableRiders.isEmpty()) {
            throw new NoAvailableRider();
        }

        int randomIndex = random.nextInt(availableRiders.size());
        Rider chosenRider = availableRiders.get(randomIndex);
        chosenRider.setAvailable(false);

        return chosenRider;
    }
        //transport
        private static TransportType pickTransport() throws InvalidMenuOptionException {
            UI.transportTypeMenu();
            option = sc.nextLine();
            switch (option) {
                case "1" -> {
                    return TransportType.BY_FEET;
                }
                case "2" -> {
                    return TransportType.BY_BICYCLE;
                }
                case "3" -> {
                    return TransportType.BY_MOTO;
                }
                default -> throw new InvalidMenuOptionException();
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
                    //complete order is not empty
                    if(products.isEmpty()){
                        throw new EmptyProductListException();
                    }
                    break;
                default:
                    throw new InvalidMenuOptionException();
            }
             } while (!option.equals("2"));

            return products;
    }

    private static Products pickProduct() throws  InvalidMenuOptionException{
        UI.productsMenu();
        option = sc.nextLine();
        return switch (option) {
            case "1" -> new Burritos();
            case "2" -> new Hamburger();
            case "3" -> new Kebab();
            case "4" -> new Pizza();
            default -> throw new InvalidMenuOptionException();
        };
    }

    // Delivery

    public static void deliveredOrder() throws  NumberFormatException, IDundefined, NullPointerException{
        listOrders();
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

    public static double calculateFinalPrice(List<Products> products, TransportType transportType) {
        double totalPrice = products.stream().mapToDouble(Products::getPrice).sum();
        return transportType.getPrice(totalPrice);
    }


}

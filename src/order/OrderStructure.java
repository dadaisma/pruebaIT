package order;

import people.Customer;
import people.Rider;

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

    public static void newOrder()

}

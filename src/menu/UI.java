package menu;

public class UI {
    public static void mainMenu(){
        System.out.println("""
        *DELIVERY BRUUMM MENU*
        1- New Order
        2- Confirm Order has been DELIVERED
        3- List Pending Orders
        4- List DELIVERED Orders
        5- Exit
        Choose an Option
    """);}

    public static void customerMenu(){
        System.out.println("*CUSTOMER'S LIST*");
        System.out.println("CHOOSE A CUSTOMER'S NAME");
    }

    public static void productsListMenu(){
        System.out.println("""
        *PRODUCT'S LIST*
        1- Choose a product
        2- Complete Order
        """);
    }

    public static void productsMenu(){
        System.out.println("""
        *PR E LI B A TE S S EN*
        1- BURRITOS
        2- HAMBURGER
        3- KEBAB
        4- PIZZA"""
        );
    }

    public static void speedMenu(){
        System.out.println("""
        1- NORMAL (by feet)
        2- FAST (by bicycle)
        3- THUNDER (by moto)
        """);
    }

    public static void deliveryMenu(){
        System.out.println("*** D E L I V E R Y ***");
        System.out.println("*Select an Order ID*");
    }



}

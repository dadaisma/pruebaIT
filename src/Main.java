import menu.UI;
import people.Customer;
import people.Rider;
import products.Burritos;
import products.Hamburger;
import products.Kebab;
import products.Pizza;
import speed.Speed;

import static menu.UI.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Customer one = new Customer("ciccio", "popi");
       Rider rider = new Rider("jonny");
        Burritos burr = new Burritos();
        Hamburger ham = new Hamburger();
        Kebab keb = new Kebab();
        Pizza piz = new Pizza();
        Speed sp = new Speed(false, true, true);

       System.out.println(one);
       System.out.println(rider);
        System.out.println(burr);
        System.out.println(ham);
        System.out.println(keb);
        System.out.println(piz);


        mainMenu();
        customerMenu();
        productsListMenu();
        productsMenu();
        speedMenu();
        deliveryMenu();
        System.out.println(sp.toString());
    }
}
import people.Customer;
import people.Rider;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Customer one = new Customer("ciccio", "popi");
       Rider rider = new Rider("jonny");
       System.out.println(one);
       System.out.println(rider);
    }
}
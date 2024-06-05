package products;

public class Hamburger extends Products{
    private static final double HAMBURGER_PRICE = 8.9;
    

    public Hamburger(){
        super(HAMBURGER_PRICE);
        this.gift = "HAT";
        gift();
    }

    @Override
    public  void gift(){
        System.out.println("With your Hamburger you will receive a " + gift + " from us as a gift!");

    }

    @Override
    public String toString() {
        return "Hamburger {" +
                "price= " + price + " €, " +
                (gift != null ? " gift: " + gift : "") +
                '}';
    }
}

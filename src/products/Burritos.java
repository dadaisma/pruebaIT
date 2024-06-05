package products;

public class Burritos extends Products{
    private static final double BURRITOS_PRICE = 6.5;


    public Burritos(){
        super(BURRITOS_PRICE);
        this.gift = "MAGIC PIN";
        gift();
    }

    @Override
    public  void gift(){
        System.out.println("With your Burrito you will receive a " + gift + " from us as a gift!");

    }

    @Override
    public String toString() {
        return "Burritos {" +
                "price= " + price + " €, " +
                (gift != null ? " gift: " + gift : "") +
                '}';
    }
}

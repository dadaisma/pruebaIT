package products;


public class Pizza extends Products {
    private static final double PIZZA_PRICE = 7.9;

    public Pizza() {
        super(PIZZA_PRICE);
        this.gift = null;
        gift();
    }

    @Override
    protected void gift() {

        System.out.println("No gift available with your Pizza.");
    }

    @Override
    public String toString() {
        return "Pizza {" +
                "price= " + price + " € " +
                (gift != null && !gift.isEmpty() ? " ,gift: " + gift : "") +
                '}';
    }
}
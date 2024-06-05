package products;

public class Kebab extends Products{
    private static final double KEBAB = 4.5;

    public Kebab(){
        super(KEBAB);
        this.gift = null;
        gift();
    }
    @Override
    protected void gift(){
        System.out.println("No gift available with your Kebab.");
    }

    @Override
    public String toString(){

        return "Kebab {" +
                "price= " + price + " € " +
                (gift != null && !gift.isEmpty() ? " ,gift: " + gift : "") +
                '}';
}
}

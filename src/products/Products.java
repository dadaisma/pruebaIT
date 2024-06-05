package products;

public abstract class Products {
    protected double price;
    protected String gift;

    public Products(double price){

        this.price = price;
        this.gift = null;
    }

    protected abstract void gift();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

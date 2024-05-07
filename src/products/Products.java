package products;

public abstract class Products {
    protected double price;

    public Products(double price){
        this.price = price;
    }

    protected abstract void gift();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

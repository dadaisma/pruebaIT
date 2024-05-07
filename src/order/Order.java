package order;

import people.Customer;
import people.Rider;
import products.Products;
import speed.Speed;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int generatedId =1;
    private final int ID;
    private Customer customer;
    private Rider rider;
    private List<Products> products = new ArrayList<>();
    private double price;
    private Speed speed;

    public Order( Customer customer, Rider rider, List<Products> products,  Speed speed) {
        this.ID = generatedId++;
        this.customer = customer;
        this.rider = rider;
        this.products = products;
        this.speed = speed;
        this.price = total();
    }

    public static int getGeneratedId() {
        return generatedId;
    }

    public static void setGeneratedId(int generatedId) {
        Order.generatedId = generatedId;
    }

    public int getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    private double total(){
        //get the total price of products
        double totalPrice = 0;
        for(Products product : products){
            totalPrice += product.getPrice();
        }
        //adjust price based on delivery type
        return speed.getPrice(totalPrice);
    }
    private String productsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i= 0; i < products.size(); i++) {
            stringBuilder.append(products.get(i).toString());
            if (i <products.size() -1){
                stringBuilder.append("\n");
            }

        }

    return stringBuilder.toString();
}

@Override
public String toString(){
    return "ID: " + ID + "\n" + customer + "\n" + rider +
            "\n Delivery Method: " + speed.toString() +
            "\n Products: " + productsToString() + "\n Total:"
            + total() + "\n-----------------------------";

    }
}

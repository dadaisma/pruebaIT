package order;

import people.Customer;
import people.Rider;
import products.Products;
import transport.Transport;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static int counter = 0;
    private final int id;
    private final Customer customer;
    private final Rider rider;
    private final List<Products> products;
    private double finalPrice;
    private final Transport transport;

    public Order(Customer customer, Rider rider, List<Products> products, Transport transport) {
        this.id = ++counter;
        this.customer = customer;
        this.rider = rider;
        this.products = products;
        this.transport = transport;
        this.finalPrice = calculateFinalPrice();
    }

    private double calculateFinalPrice() {
        double totalPrice = products.stream().mapToDouble(Products::getPrice).sum();
        return transport.getPrice(totalPrice);
    }

    public int getID() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Rider getRider() {
        return rider;
    }

    public List<Products> getProducts() {
        return products;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public String toString() {
        String productsString = products.stream()
                .map(Products::toString)
                .collect(Collectors.joining("\n"));

        return "Order ID: " + id + "\n" +
                "Customer: " + customer.getName() + "\n" +
                "Rider: " + rider.getName() + "\n" +
                transport.toString() + "\n" +
                "Products:\n" + productsString + "\n" +
                "Final Price: " + finalPrice + "€";
    }
}

package order;

import people.Customer;
import people.Rider;
import products.Products;
import transport.Transport;
import transport.TransportType;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static int counter = 0;
    private final int id;
    private final Customer customer;
    private final Rider rider;
    private final List<Products> products;
    private double finalPrice;
    private final TransportType transportType;

    public Order(Customer customer, Rider rider, List<Products> products, TransportType transportType, double finalPrice) {
        this.id = ++counter;
        this.customer = customer;
        this.rider = rider;
        this.products = products;
        this.transportType = transportType;
        this.finalPrice = OrderStructure.calculateFinalPrice(products, transportType);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
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

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    @Override
    public String toString() {
        String productsString = products.stream()
                .map(Products::toString)
                .collect(Collectors.joining("\n"));

        double totalPrice = products.stream().mapToDouble(Products::getPrice).sum();
        double transportPrice = transportType.getPrice(products.stream().mapToDouble(Products::getPrice).sum());
        double extraChargePercentage = (transportPrice - totalPrice);

        String extraChargeString = String.format("Extra Charge for Transport: %.2f€", extraChargePercentage);

        return "Order ID: " + id + "\n" +
                "Customer: " + customer.getName() + "\n" +
                "Rider: " + rider.getName() + "\n" +
                transportType + "\n" +
                extraChargeString + "\n" +
                "Products:\n" + productsString + "\n" +
                "Final Price: " + finalPrice + "€";
    }
}

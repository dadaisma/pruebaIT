package transport;

public class ByBicycle extends Transport {
    @Override
    public double getPrice(double totalPrice) {
        return totalPrice * 1.01;
    }

    @Override
    public String toString() {
        return "Transport: Fast, by bicycle, extra charge of 1%";
    }
}
package transport;

public class ByMoto extends Transport {
    @Override
    public double getPrice(double totalPrice) {
        return totalPrice * 1.02;
    }

    @Override
    public String toString() {
        return "Transport: Thunder, by moto, extra charge of 2%";
    }
}
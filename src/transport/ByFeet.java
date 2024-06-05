package transport;

public class ByFeet extends Transport {
    @Override
    public double getPrice(double totalPrice) {
        return totalPrice; // No extra charge for by feet delivery
    }

    @Override
    public String toString() {
        return "Transport: Normal, by feet, no extra charge";
    }
}
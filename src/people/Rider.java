package people;
import transport.Transport;

public class Rider extends People {
    private boolean available;
    private Transport deliveryTransport;

    public Rider(String name) {
        super(name);
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Rider: " + name + " Available: " + available + " " + (deliveryTransport != null ? deliveryTransport.toString() : "No transport assigned");
    }
}
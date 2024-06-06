package people;

import transport.TransportType;

public class Rider extends People {
    private boolean available;
    private TransportType deliveryTransport;

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

    public void assignTransport(TransportType transportType) {
        this.deliveryTransport = transportType;
    }

    @Override
    public String toString() {
        return "Rider: " + name + " Available: " + available +
                (deliveryTransport != null ? " " + deliveryTransport.toString() : " No transport assigned");
    }
}

package transport;

public enum TransportType {
    BY_MOTO {
        @Override
        public double getPrice(double totalPrice) {
            return totalPrice * 1.02;
        }

        @Override
        public String toString() {
            return "Transport: Thunder, by moto, extra charge of 2%";
        }
    },
    BY_FEET {
        @Override
        public double getPrice(double totalPrice) {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Transport: Normal, by feet, no extra charge";
        }
    },
    BY_BICYCLE {
        @Override
        public double getPrice(double totalPrice) {
            return totalPrice * 1.01;
        }

        @Override
        public String toString() {
            return "Transport: Fast, by bicycle, extra charge of 1%";
        }
    };

    // Abstract method to calculate price
    public abstract double getPrice(double totalPrice);
}

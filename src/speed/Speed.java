package speed;

public class Speed {
    private boolean byFeet;
    private boolean byBicycle;
    private boolean byMoto;

    public Speed(boolean byFeet, boolean byBicycle, boolean byMoto){
        this.byFeet = byFeet;
        this.byBicycle = byBicycle;
        this.byMoto = byMoto;
    }

    public double getPrice(double totalPrice){
        if(byBicycle){
            return totalPrice * 1.01;
        } else if (byMoto) {
            return totalPrice * 1.02;

        }
        else {
            return totalPrice;
        }
    }

    @Override
    public String toString(){
        if(byFeet){
            return "Speed Delivery chosen: Normal";
        } else if (byBicycle) {
            return "Speed Delivery chosen: Fast, by bicycle";

        } else if(byMoto){
            return "Speed Delivery chosen: Thunder, by moto";
        } else {
            return "Unknown speed delivery";
        }
    }
}

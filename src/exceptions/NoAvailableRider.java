package exceptions;

public class NoAvailableRider extends Exception{
    public NoAvailableRider(){
        super("ERROR: No Riders Available, you need to wait, kindly consider to hire more riders to avoid this in the future");

    }
}

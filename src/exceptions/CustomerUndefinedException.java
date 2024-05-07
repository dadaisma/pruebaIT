package exceptions;

public class CustomerUndefinedException extends Exception {
    public CustomerUndefinedException(){
        super("ERROR: CUSTOMER NOT FOUND, try again");
    }
}

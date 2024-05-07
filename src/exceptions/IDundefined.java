package exceptions;

public class IDundefined extends Exception{
    public IDundefined(){
        super("ERROR: ID not found or undefined, please try again");
    }
}

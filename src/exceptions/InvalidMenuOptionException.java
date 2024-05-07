package exceptions;

public class InvalidMenuOptionException extends Exception{
    public InvalidMenuOptionException(){
        super("ERROR: Invalid Menu Option, please try again");
    }
}

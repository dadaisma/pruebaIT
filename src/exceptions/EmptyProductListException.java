package exceptions;

public class EmptyProductListException extends  Exception{
    public EmptyProductListException(){
        super("ERROR: Product List cannot be EMPTY");
    }
}

package products;

public class Pizza extends Products{
    public Pizza(){
        super(7.9);
    }

    @Override
    protected void gift(){

    }

    @Override
    public String toString(){
        return "Pizza {"+ "price="+price+" €" + '}';
    }
}

package products;

public class Kebab extends Products{
    public Kebab(){
        super(4.5);

    }
    @Override
    protected void gift(){

    }

    @Override
    public String toString(){
        return "Kebab {"+ "price= "+ price + " €" +'}';
    }
}

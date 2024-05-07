package products;

public class Burritos extends Products{
    public Burritos(){
        super(6.5);
        gift();
    }

    @Override
    public  void gift(){
        System.out.println("you will receive a MAGIC PIN from us as a gift!");

    }

    @Override
    public String toString(){
        return "Burritos {"+ "price= "+price +" €" +'}';
    }
}

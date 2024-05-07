package products;

public class Hamburger extends Products{

    public Hamburger(){
        super(8.9);
        gift();
    }

    @Override
    public void gift(){
        System.out.println("you will receive a wonderful Hat from us as gift!");

    }

    @Override
    public String toString(){
        return "Hamburger {"+"price= "+ price+" €" +'}';
    }
}

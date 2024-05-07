package people;

public class Customer extends People{
    private String address;

    public Customer(String name, String address){
        super(name);
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "Customer: "+ super.name+"Address: "+address;
    }
}

package people;

public abstract class People {
    protected String name;

    public People(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package lut.day8;

public class Tree extends  Plant{
    String name;
    Tree(String name){
        this.name = name;
    }
    public void plantName(Plant plant){
        plant.plant(name);
    }

    @Override
    public void plant(String name) {

    }
}

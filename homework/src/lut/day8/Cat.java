package lut.day8;

public class Cat{
    String name;
    public Cat(String name){
        this.name =name;
    }

    public void catName(Animal animal){
        animal.animal(name);
    }
    public void sex(Cat c){
        System.out.println("大胖母猫");
        c.sex();
    }
    public void sex(){
        System.out.println("大母猫");
    }
}

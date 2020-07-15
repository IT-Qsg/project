package lut.day7.exe1;

public class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name){
        this();
        this.name = name;
    }
    public Cat(){
        super(4);
    }

    @Override
    public void eat() {
        System.out.println("猫边舔边吃");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
            this.name = name;
    }

    @Override
    public void play() {
        System.out.println("猫"+name+"爪子挠你");
    }
}

package lut.day7.exe1;

public class Fish extends Animal implements Pet{
    private String name;
    Fish(){
        super(4);
    }
    @Override
    public void eat() {
        System.out.println("鱼要吸着吃");
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
        System.out.println("鱼儿跃出水面");
    }
}

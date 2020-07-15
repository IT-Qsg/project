package lut.day7.exe1;

public class Spider extends  Animal{
    public Spider(){
        super(8);
    }
    @Override
    public void eat() {
        System.out.println("蜘蛛网粘住苍蝇");
    }
}

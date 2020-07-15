package lut.day5.exe1;

public class Circle extends Shape{
    double r;
    public Circle(){
        r = 1.0;
    }

    public Circle(double r) {
        this.r = r;
    }

    public Circle(int x, int y, double r) {
        super(x, y);//调用父类对应构造器
        this.r = r;
    }
    public void draw(){
        System.out.println("draw in circle  x="+x+",y="+y+",r="+r);
    }
}

package lut.day5.exe1;

public class Rectangle extends Shape{
    double height,width;
    public Rectangle(){
        height = 1.0;
        width = 1.0;
    }

    public Rectangle(double height,double width){
        this.height = height;
        this.width = width;
    }
    public Rectangle(int x,int y,double height,double width){
        /*this.x = x;
        this.y = y;*/
        super(x,y);
        this.height =height;
        this.width = width;
    }
    public void draw(){
        System.out.println("draw in rectangle x = "+x+",y = "+y+",height = "+height+",width = "+width);
    }
}

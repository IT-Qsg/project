package lut.day5.exe1;

public class Shape {
    int x,y;
    public Shape(){
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
       System.out.println("Shape");
        draw();
        A();
    }
    public void draw(){
            System.out.println("Shape draw x ="+x+", y = "+y);
    }
    public void A(){
        System.out.println("A");
    }
}

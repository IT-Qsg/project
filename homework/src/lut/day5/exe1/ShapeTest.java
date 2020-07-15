package lut.day5.exe1;

public class ShapeTest {
    public  static  void main(String... arge){
        /*Shape sh = new Shape();
        sh.draw();//00
        sh = new Shape(3,4);
        sh.draw();//3 4
        Circle c1 = new Circle();
        c1.draw();//0 0 1.0
        c1 = new Circle(5.5);
        c1.draw();//0 0 5.5
        Shape c2 = new Circle(1,1,3.3);
        c2.draw();//Shape 1 1 0  1 1 3.3
        Rectangle r = new Rectangle();
        r.draw();//0 0 1.0 1.0
        r = new Rectangle(2.0,2.3);
        r.draw();//0 0 2.3 2.3
        r = new Rectangle(5,4,6.3,2.4);
        r.draw();//5 4 6.3 2.4
        Shape r1 = new Rectangle(5,4,6.3,2.4);
        r.draw();*/
        Shape[] s={new Shape(1,4), new Rectangle(1,2,3,4), new Circle(2,3,5)};
        for(int k = 0; k < s.length; k++){
            s[k].draw();
        }
        /*
        * shape
        * 1 4
        *
        * shape
        * 2 3 0.0
        *
        * 1 4
        * 1 2 3.0 4.0
        * 2 3 5.0
        * */

        /*
        * shape
        * 1 4
        *
        * shape
        * 1 2 0 0
        *
        * shape
        * 2 3 0.0
        *
        * 1 4
        * 1 2 3.0 4.0
        * 2 3 5.0
        *
        * */
    }
}

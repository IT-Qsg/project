package lut.day6;

public class Z_day6_1 {
    public static void main(String... arge){
        A();
    }
    public static void A(){
        Z_day6_1 z = new Z_day6_1();
        z.B();
        System.out.println("A");
    }
    public void B(){
        System.out.println("B");
    }
}

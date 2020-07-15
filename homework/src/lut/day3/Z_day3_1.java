package lut.day3;
public class Z_day3_1 {
    public enum Test{
        num1,nu;
    };
        public static void main(String [] arge){
            System.out.println("hhhhhh"+Test.num1);
        Object o1 = new Object();
        System.out.println(o1);
        Object o2 = new Object();
        o1 = o2;
        System.out.println(o1+"  "+o2);

        int a = 5,c;
        double b = 2.0;
        c = a/(int)b;
        System.out.println(c);

        int d = 10%(-6);
        System.out.println(d);

    }

}

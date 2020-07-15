package Exe.fuxi;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    static int a[] = {1};
    static int b[] = {1};
    int v = 1;
    class SS{
        int v = 2;
        void show(){
            System.out.println(Test.this.v);
            System.out.println(new Test().new SS().v);
            System.out.println(new Test().v);
            System.out.println(Test.a);
            System.out.println(a);
        }
    }
    static void aa(){

    }
    public static void main(String[] args) {
//        System.out.println(a[0] == b[0]);
//        short a = 1;
//        a +=1;
//        int b = a;
//        byte c = 1;
//        c = (byte)(c +a );
//        Object o1 = new Object();
//        System.out.println(o1);
//        Object o2 = new Object();
//        o1 = o2;
//        System.out.println(o1==o2);
//        Object o = new Object();
//        Z_day3_2 z =(Z_day3_2) o;
//        int a = 5,c;
//        double b = 2.0;
//        c = a/(int)b;
//        System.out.println(c);//c = 2;
//        double c = 12.0%10.0;
//        System.out.println(c);
//        double b = 12.0%10;
//        System.out.println(b);
//        double a = 12%10.0;
//        System.out.println(a);
//        double d = -12%10.0;
//        System.out.println(d);
//        double e =  12%-10.0;
//        System.out.println(e);
       /* byte a = -3>>100;
        *//*
        * 1000 0011
        * 1111 1101 右移动一位加一
        * 1000 0010
        * 1111 1111
        * 1111 1110
        * 1000 0001
        * *//*
        System.out.println(a);*/
//        int []x ,y[],u[];
//        x = new int [10];
//        int []z = x;
//        y = new int [20][];
//        int c[][] = new int [10][];

//        int[] x = new int[3];
//        System.out.println(x);
//        int[] y = x;
//        System.out.println(y);
//        x = new int[4];
//        System.out.println(x);

        Integer []u ={1,5,4,3,9,1} ;
        Arrays.sort(u, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                for (Integer integer : u) {
                    System.out.print(integer+"  ");
                }
               // int i = o1.compareTo(o2);
                System.out.println("o1:"+o1+"<---> o2:"+o2);
                return o1-o2>=0?-1:1;
//                return i;
            }
        });
        for (Integer integer : u) {
            System.out.print(integer+"  ");
        }

    }
}
class Z_day3_2{}
class C1{
    public C1(String s) {
    }

}
class C2 extends C1{

    public C2(String s) {
         super(s);
    }

    public C2() {
        this("ddd");
    }
    static{
        String s;
    }
}
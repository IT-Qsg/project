package lut.day1;

public class Swap {

    public static void main(String[] args){
        int [] t = new int[2];
        t[0]=1;
        t[1]= 2;
        int a = 10,b = 12;
        swap(a,b);
        //System.out.println("a="+a+"b="+b);
        swap(t);
        System.out.println(t[0]+" "+t[1]);
    }
    public static void swap(int a,int b){
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println("a="+a+"b="+b);
    }
    public static void swap(int d[]){
        int c;
        c = d[0];
        d[0] = d[1];
        d[1] = c;
    }
}

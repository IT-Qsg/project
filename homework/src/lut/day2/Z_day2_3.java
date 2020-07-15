package lut.day2;

public class Z_day2_3 {

    public static void main(String [] arge){
        System.out.println(factorial(4));
    }
    public static int factorial(int X){
        /*int i = 1,fact = 1;
        for(;i<=X;i++){
            fact*=i;
        }
        return fact;*/
        int mul = 1 ;
        while(X>0)
        {
            mul *=X;
            X--;
        }
        return  mul;
    }
}

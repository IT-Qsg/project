package lut.day2;

public class Z_day2_2 {
    public static void main(String [] arge){
        int mulSum = 1,i = 1;
        /*while(i<=10){
            mulSum *= i;
            i++;
        }*/
       /*do{
           mulSum *= i;
           i++;
       }while(i <= 10);*/
       for(;i<=10;i++){
           mulSum *= i;
       }
        System.out.println(mulSum);
    }
}

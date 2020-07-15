package lut.day3;
//水仙花
public class Z_day3_4 {
    public static void main(String[] arge){
        int num = 151;
        boolean f = flower(num);
        if(f==true)
            System.out.println("是");
        else
            System.out.println("否");
    }
    public static boolean flower(int num){
        int a,b,c,d;//百位，十位，个位,水仙花数
        a = num/100;
        b = (num%100)/10;
        c = (num%100)%10;
        d = a*a*a + b*b*b + c*c*c;
        if(num == d)
            return true;
        else
            return false;
    }
}

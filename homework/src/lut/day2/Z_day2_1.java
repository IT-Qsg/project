package lut.day2;

import java.util.Scanner;

public class Z_day2_1 {
    public static void  main(String [] arge){
       //short s1 = 1; s1 += 1;
       /* short s1 = 1; s1 = (short)(s1 + 1);
        System.out.println(s1);*/
        Float [] f = new Float[3];
        /*inputNum(f);
        cmp(f);*/
        inputThreeNum(f);
    }
    public static void inputNum(Float[] f){
        System.out.println("请输入第一个数：");
        Scanner num1 = new Scanner(System.in);
        Float n1 = num1.nextFloat();
        f[0] = n1;
        System.out.println("请输入第二个数：");
        Scanner num2 = new Scanner(System.in);
        Float n2 = num2.nextFloat();
        f[1] = n2;
    }
    public static void cmp(Float[] f){
        if(f[0].equals(f[1]))
            System.out.println("输入的两个数字相等");
        else
            System.out.println("输入的两个数字不相等");
    }
    public static void inputThreeNum(Float[] f){
        inputNum(f);
        System.out.println("请输入第三个数：");
        Scanner num3 = new Scanner(System.in);
        Float n3 = num3.nextFloat();
        f[2] = n3;
        cmpThreenum(f);
    }
    /*public static void cmpThreenum(Float[] f){
        Float max = (f[0]>f[1]) ? ((f[0]>f[2]) ? f[0]:f[2]) : (f[1]>f[2] ? f[1] : f[2]);
        if(f[0]>f[1]){
            if(f[0]>f[2])
                System.out.println("最大值："+f[0]);
        }else if(f[1]>f[2]){
                System.out.println("最大值："+f[1]);
        }else
                System.out.println("最大值："+f[2]);
    }*/
    /*public static void cmpThreenum(Float[] f){
        Float max = (f[0]>f[1]) ? ((f[0]>f[2]) ? f[0]:f[2]) : (f[1]>f[2] ? f[1] : f[2]);
        System.out.println("最大值："+max);
    }*/
    public static Float comTwoNum(Float num1, Float num2){
        if(num1 > num2)
            return num1;
        else
            return num2;
    }
    public static void cmpThreenum(Float[] f){
        Float max = (f[0]>f[1]) ? comTwoNum(f[0],f[2]) : comTwoNum(f[1],f[2]);
        System.out.println("最大值："+max);
    }
}

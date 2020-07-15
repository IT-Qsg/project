package lut.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class grade {

    public static void main(String[] args){
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));//可能出现异常
            System.out.println("请输入0-------100的数字！");
            Float g = Float.parseFloat(b.readLine());
            //Integer g = Integer.parseInt(b.readLine());//出现异常即为输入为非数字
            String ga = (g>=0 && g<60)?("等级为E"):((g>=60 && g<70) ? ("等级为D"):
                            ((g>=70 && g<80)?("等级为C"):((g>=80 && g<90)? ("等级为B"):
                                 ((g>=90 && 100>=g) ? ("等级为A"):("输入数字不在1~100内"))) ));
            System.out.println(ga);
        }catch (IOException e){
            e.printStackTrace();
        }catch(NumberFormatException s){
            System.out.println("输入类型不正确！");
        }

      /* if(g>=0 && g<60)
           System.out.println("等级为E");
       else if(g>=90 && 100>g)
           System.out.println("等级为A");
       else if(60<=g && g<70)
           System.out.println("等级为D");
       else if(80<=g &&g <90)
           System.out.println("等级为B");
       else if(70<=g && g<80)
           System.out.println("等级为C");
        else
           System.out.println("输入的数字不在0~100之间");*/


    }
}

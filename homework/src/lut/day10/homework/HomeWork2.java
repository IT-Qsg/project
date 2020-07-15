package lut.day10.homework;

import java.util.HashSet;
import java.util.Set;

public class HomeWork2 {
    public static void main(String[] args) {
        Set set = new HashSet<Object>();
        int i = 0;
        while(set.size()<6){
            int num = (int)(Math.random()*34);
            if(num<10)
            set.add("红球：0"+num);
            else
                set.add("红球："+num);
        }
        while(set.size()<7){
            int num = (int)(Math.random()*17);
            if(num<10)
            set.add("蓝球：0"+num);
            else
                set.add("蓝球："+num);
        }
        System.out.println(set);

    }


}

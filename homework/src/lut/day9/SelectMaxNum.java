package lut.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectMaxNum {
    Scanner s;
    List list;
    public int maxNum(){
        list = new ArrayList();
        int max;
        while(true){
            s = new Scanner(System.in);
            max =s.nextInt();
            if(max == 0){
                max = (int)list.get(0);
                    for(Object o : list){
                         if(max<(int)o) max = (int)o;
                         else continue;
                    }
                return  max;
            }else{
                list.add(max);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SelectMaxNum().maxNum());
    }
}

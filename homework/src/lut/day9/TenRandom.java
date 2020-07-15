package lut.day9;

import java.util.List;
import java.util.ArrayList;

public class TenRandom {
    public static void main(String[] args) {
        List list = new TenRandom().tenRandom();
        list.forEach(System.out::println);
        list.forEach((o)->System.out.println("->"+o));
        list.forEach((Object o)->{System.out.println("lambda:"+o);});
        System.out.println(list);
    }
    public List tenRandom(){
        List list = new ArrayList<Integer>();
        while(list.size()<10){
           int a = (int)(Math.random()*20);
            if(list.contains(a))
                continue;
            else
                list.add(a);
        }
        return list;
    }
}

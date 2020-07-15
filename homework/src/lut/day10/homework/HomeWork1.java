package lut.day10.homework;

import lut.day11.GenSetTest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class HomeWork1 {

   /* @Override
    public boolean equals(Object o){
        System.out.println("2222222");
        return  false;
    }*/
    public static void main(String[] args) {
        //Set set = new  TreeSet<String>(new GenSetTest<String>().comparator());
       /* Set set = new TreeSet<String>((o1,o2) ->{
                int num = o1.compareTo(o2);
                return num == 0 ? 1: num;
        });*/
       /* Set set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num = o1.compareTo(o2);
                return num == 0 ? 1 : num;
            }
        });*/
        Set set = new  TreeSet<String>((s1,s2)->s1.compareTo(s2)==0?1:s1.compareTo(s2));
        set.add("jdhdk");
        set.add("jdhdk");
        set.add("ghh");
        set.add("jtry");
        set.add("afg");
        set.add("jdhdk");
        set.add("ghh");
        set.add("jtry");
        set.add("jdhdk");
        set.add("ghh");
        set.add("jtry");
        set.add("bf");
        for(Object o : set)
            System.out.println(o);
    }
}


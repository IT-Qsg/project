package lut.day10.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class HomeWork4 extends Object{

    static String s="" ;

    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("sdgsd");
        list.add("dfsdfks");
        list.add("oiweiugf");
        list.forEach(d->{
            s+=d;
        });
        /*list.forEach((new Consumer<String>() {
            @Override
            public void accept(String d) {
                s+=d;
            }
        }));*/
        System.out.println("------------------");
        Set set = new HashSet<Object>();
        int count;
        char c;
        char[] ss = s.toCharArray();
        for(int i = 0 ;i< ss.length;i++) {
            count = 0;
            c = ss[i];
            for (int j = 0; j < ss.length; j++) {
                if (ss[i] == ss[j]) {
                    c = ss[i];
                    ++count;

                }
            }
            set.add(c+":"+count);

        }

        System.out.println(set);


    }
}

package lut.day10;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(90);
        set.add(30);
        System.out.println(set);
        for(Object o : set){

            if(30 == (int)o){
                set.add(60);
                set.remove(90);
            }
        }
        System.out.println(set);
    }
}
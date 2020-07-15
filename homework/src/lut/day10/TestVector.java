package lut.day10;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args) {
        List list = new ArrayList<Object>();
        for (int i =0;i<10;i++){
            list.add(i);
        }
        List vector = new Vector<Object>();
        for (int i =0;i<10;i++){
            vector.add(i);
        }
        list.add(vector);
       // System.out.println(list);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());};
    }
}

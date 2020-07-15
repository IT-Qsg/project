package lut.day11;

import java.util.Comparator;
import java.util.TreeSet;

public class GenSetTest<E> extends TreeSet<E> {

    @Override
    public Comparator<? super E> comparator(){
        return  new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                int num = s1.compareTo(s2);
                return num == 0 ? 1 : num;
            }
        };
    }
}

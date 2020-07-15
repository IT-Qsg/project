package lut.day11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestComparator {
    public static void main(String[] args) {
        Set set = new TreeSet<String>(new A());
        set.add("jshfkj");
        set.add("abc");
        set.add("abc");
        set.add("jshfkj");
        set.add("4555");
        set.add("4432");
        set.add("gfh");
        set.add("reffg");
        System.out.println(set);
    }

}
class A implements Comparator{

    //重写比较器
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        return s1.compareTo(s2)==0 ? 1 : s1.compareTo(s2);
    }
}

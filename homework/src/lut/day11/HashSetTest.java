package lut.day11;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {

    public static void main(String[] args) {
       // Set<B> set = new TreeSet<>();
        Set<B> set = new HashSet<>();
        set.add(new B(20,"haha"));
        set.add(new B(10,"haha"));
        set.add(new B(10,"haha"));
        System.out.println(set);
    }
}
class B implements Comparable{
    private Integer age;
    private String name;

    public B(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        boolean b = this.name == ((B)(o)).name;
        boolean c = this.age == ((B)(o)).age;
        return  b&&c;
    }
    @Override
    public int hashCode(){
        int namehashcode = this.name.hashCode();
        int agehashcode = this.age.hashCode();
        System.out.println(namehashcode+"----------"+agehashcode);
        return namehashcode+agehashcode;
    }
    @Override
    public String toString(){
        return this.name+"===="+this.age;
    }


    @Override
    public int compareTo(Object o) {
        return this.age - ((B)o).age;
    }
}
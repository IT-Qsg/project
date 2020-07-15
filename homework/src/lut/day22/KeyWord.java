package lut.day22;

import java.util.ArrayList;

public class KeyWord {
    public static void main(String[] args) {
        Integer v = new Util<Integer, String>() {
            @Override
            public Integer show(String s) {
                return Integer.parseInt(s);
            }
        }.show("1234");
       // System.out.println(v);
        Util<Integer, String> u = Integer::new;
        System.out.println(u+"-------uuuuuu");
        Integer s1 = u.show("123");
        Util<Integer, String> u2 = new Util<Integer, String>() {
            @Override
            public Integer show(String s) {
                return new Integer(s);
            }
        };
        u2.show("234");

        System.out.println(s1);
        System.out.println("-----------------------------");

        SI<Student,String,Integer> si = Student::new;

        System.out.println( si.prin("张三",20));
        System.out.println(si);

        SI<Student,String,Integer> sii = new SI<Student, String, Integer>() {
            @Override
            public Student prin(String s, Integer integer) {
                return new Student(s,integer);
            }
        };

    }
}
interface Util<X,Z>{
    X show(Z z);
}
interface SI<X,Y,Z>{
    X prin(Y y,Z z);
}
class Student{
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Fun{
   static public void show(String s){
        System.out.println(s);
    }
     public void show2(String s){
        System.out.println(s);
    }

    public void test(){
    ArrayList<String> a  =new ArrayList<>();
    a.add("1shfjs");
    a.add("1shfjs");
    a.add("1shfjs");
    a.add("1shfjs");

    a.forEach(Fun::show);
}
public void Test(){
       Fun f = new Fun();
    ArrayList<String> a  =new ArrayList<>();
    a.add("1shfjs");
    a.add("1shfjs");
    a.add("1shfjs");
    a.add("1shfjs");

    a.forEach(f::show2);
}

    public static void main(String[] args) {
        new Fun().test();
        new Fun().show("jjj");
        new Fun().Test();
    }
}
package lut.day10.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: bd1904.java
 * @description: .HashSet演示
 * @author: Kevin
 * @create: 2019-08-05 16:25
 **/
public class HashSetTest{
    public static void main(String[] args){
        // Set set=new HashSet();
        //
        // set.add("Hello");
        // set.add(10);
        // set.add(true);
        // set.add("Hello");
        //
        // System.out.println(set);

        Set set=new HashSet();

        Student s1=new Student("张三",10);
        Student s2=new Student("李四",11);
        Student s3=new Student("王五",12);
        Student s4=new Student("赵六",13);
        Student s5=new Student("赵六",14);
        Student s6=new Student("孙八",12);
        Student s7=new Student("王五",12);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        set.add(s6);
        set.add(s7);

        System.out.println(set);

        // 需求：当学生姓名是王五时，添加新的学生对象；
        // for(Object o : set){
        //     // System.out.println(o);
        //     Student s=(Student)o;
        //     if("王五".equals(s.name)){
        //         set.add(new Student("孙八",10000));
        //         set.remove(s1);
        //     }
        // }
        //
        // System.out.println(set);

        // 需求：当学生姓名是王五时，添加新的学生对象；
        Iterator it=set.iterator();
        while(it.hasNext()){
            Object o=it.next();
            // System.out.println(o);
            Student s=(Student)o;
            if("王五".equals(s.name)){
                set.add(new Student("孙八",10000));
            }
        }

        System.out.println(set);

        System.out.println("--------------------------");

        set.forEach(System.out::println);











        // System.out.println(set);
        //
        // set.remove(s6);
        //
        // System.out.println(set);
        //
        // s2.age=1000;
        //
        // set.add(s2);
        //
        // System.out.println(set);

    }
}

class Student extends Object{
    String name;
    int age;

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int hashCode(){
        // System.out.println(this.name);
        // System.out.println(this.name+"@@"+this.age+"@@");
        return this.name.hashCode()+this.age;
        // return super.hashCode();
    }

    public boolean equals(Object o){
        Student s=(Student)o;
        boolean nameComp=this.name.equals(s.name);
        boolean ageComp=
            Integer.valueOf(this.age).equals(Integer.valueOf(s.age));
        return nameComp&&ageComp;
        // return super.equals(o);
    }

    @Override
    public String toString(){
        return this.name+"::"+this.age;
    }
}


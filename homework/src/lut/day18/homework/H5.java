package lut.day18.homework;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class H5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* List<Student> list = new ArrayList<>();
        list.add(new Student("张三",20,85));
        list.add(new Student("王三",20,85));
        list.add(new Student("李三",20,85));
        list.add(new Student("赵三",20,85));
        list.add(new Student("旁三",20,85));*/
    //    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\Student.txt");
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\Student.txt"));
        Set<Student> set = new TreeSet<>();
        set.add(new Student("张三",20,85));
        set.add(new Student("王三",20,85));
        set.add(new Student("王三",10,85));
        set.add(new Student("李三",10,85));
        set.add(new Student("赵三",20,100));
        set.add(new Student("旁三",20,85));
        set.add(new Student("Tom",20,85));
        set.add(new Student("son三",20,85));
        //System.out.println(set);

          out.writeObject(set);
          out.flush();

        ObjectInputStream oin =
                new ObjectInputStream(
                        new FileInputStream("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\Student.txt"));
       /* try{
            Object o;
            while(true){
               o = oin.readObject();
               System.out.println(o);
            }
        }catch(EOFException e){
            System.out.println("对象已经读完");
        }*/

        Object o = oin.readObject();
        TreeSet<Student> o1 = (TreeSet<Student>) o;
        o1.forEach(Student->{
            System.out.println(Student);
        });

        oin.close();
        out.close();
        /*Object o = oin.readObject();System.out.println(o);
               o = oin.readObject();System.out.println(o);
               o = oin.readObject();System.out.println(o);
               o = oin.readObject();System.out.println(o);
               o = oin.readObject();System.out.println(o);
               //o = oin.readObject();System.out.println(o);
               //o = oin.readObject();System.out.println(o);*/
        //String s = o.toString();
       /* Class<?> aClass = Class.forName(s);
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }*/
    }
}
class Student implements Serializable,Comparable{
    private  final  static long serialVersionUid = 1L;
    String name;
    int age;
    int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        int i = this.name.compareTo(((Student) o).name);
        int j =this.age-((Student)o).age;
        int k = this.score-((Student)o).score;
        if(i==0) {
            if (j == 0)
                return k;
            return j;
        }return i;
    }

   /* @Override
    public String toString() {
        return this.getClass().getName();
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

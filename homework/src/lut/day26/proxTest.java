package lut.day26;

import java.io.FileNotFoundException;

public class proxTest {
    public static void main(String[] args) {
        manageStudent manageStudent = new manageStudent();
        for(int i = 0;i<10000;i++){
        manageStudent.add(new Student("永远十八",18));
        manageStudent.delect(new Student("已经出局",50));
        }
    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
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
interface Manage{
    void add(Student s);
    void delect(Student s);
}
class optStudent implements Manage{

    @Override
    public void add(Student s) {
        System.out.println("添加了学生"+s);
    }

    @Override
    public void delect(Student s) {
        System.out.println("删除了学生"+s);
    }
}
class manageStudent extends optStudent implements Manage{
    @Override
    public void add(Student s) {
        try {
            Logger.log("添加了学生："+s.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.add(s);
    }

    @Override
    public void delect(Student s) {
        try {
            Logger.log("删除了学生："+s.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.delect(s);
    }
}

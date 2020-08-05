package com.dfec.flink.mysql;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Student
 * @Date 2020/7/29 14:15
 * @Copyright DFEC
 **/
public class Student {
    private int id;
    private String name;
    private String password;
    private String age;

    public Student() {
    }

    public Student(int id, String name, String password, String age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

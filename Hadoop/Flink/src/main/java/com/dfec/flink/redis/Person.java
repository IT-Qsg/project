package com.dfec.flink.redis;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Person
 * @Date 2020/7/29 16:52
 * @Copyright DFEC
 **/
public class Person {
    private int id;
    private String name;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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
}

package com.dfec.day7_2.required.req;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 8:04
 * @describe
 **/
public class Person {
    private  String name;
    private String address;
    private  int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

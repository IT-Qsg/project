package lut.day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest1 {
    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException
    {
        String str = "lut.day13.Teacher";
        Class<?> tc = Class.forName(str);
       // System.out.println(tc);
        Object o = tc.newInstance();//通过镜像创建对象
       // System.out.println(o);

        Constructor<?> cons = tc.getConstructor();
       // System.out.println(cons);
        Object objects =cons.newInstance();//通过构造器创建对象
       // System.out.println(objects);
        Constructor<?> tcConstructor = tc.getConstructor(double.class, int.class, int.class, String.class);
        System.out.println(tcConstructor);
       Object jdj = tcConstructor.newInstance(1.0, 1, 1, "jdj");
        System.out.println(jdj);
    }
}
class Person{
    private  String name;
    private  Integer age;
    private double weight;
    double height;
    protected  String address;

    public Person() {
    }

    public Person(String name, Integer age, double weight, double height, String address) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
/*
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", address='" + address + '\'' +
                '}';
    }*/
}
class Teacher extends  Person{
    double scalary;
    private int teachAge;
    int gender;
    protected String telephone;

    public Teacher() {
    }

    public Teacher(double scalary, int teachAge, int gender, String telephone) {
        super();
        this.scalary = scalary;
        this.teachAge = teachAge;
        this.gender = gender;
        this.telephone = telephone;
    }

    public void teach(){

    }
    public double getScalary() {
        return scalary;
    }

    public void setScalary(double scalary) {
        this.scalary = scalary;
    }

    public int getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(int teachAge) {
        this.teachAge = teachAge;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"@"+this.hashCode()+
                "Teacher{" +
                "scalary=" + scalary +
                ", teachAge=" + teachAge +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
package lut.day22;

public class DefaultMethodTestInterface {
    public static void main(String[] args) {
        Person.say();
        ((Person)()->{}).walk();
    }
}
interface  Person{
    void  eat();
    default void walk(){
        System.out.println("走");
    }
    static void say(){
        System.out.println("说");
    }
}
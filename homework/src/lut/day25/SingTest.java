package lut.day25;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingTest {
    public static void main(String[] args) {
        System.out.println(Util.getInstance());
        System.out.println(Util.getInstance());
        System.out.println(Util.getInstance());
        System.out.println(Util.getInstance());
        System.out.println(Util.getInstance());
        System.out.println("------------------");
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();


        try {
            String className = "lut.day25.Util";
            Class<?> c = Class.forName(className);
           /* Constructor<?>[] con = c.getDeclaredConstructors();
            for (Constructor<?> constructor : con) {
                System.out.println(constructor);
            }*/
            Constructor<?> con = c.getDeclaredConstructor(int.class);
            con.setAccessible(true);
            Object o = con.newInstance(0);
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println( Util.getInstance());
    }
}
class Util{
    private  static final Util U = new Util(0);
    private static int count;
    private Util(int in){
        count ++;
        if(count>1)throw new RuntimeException("只能创建一次对象");
    }
    public static Util getInstance(){
        return U;
    }
}
class Util2{
    private static Util2 U2;
    private Util2(){
        U2  = new Util2();
    }
    public static Util2 getInstent(){
        return U2;
    }
}
class Util3{
    private static Util3 U3= null;
    private Util3(){}
    public static Util3 getIntance(){
        if(U3==null){
            synchronized (Util3.class){
            if(U3==null)
               { System.out.println(Thread.currentThread().getName());
                U3 = new Util3();}
            }
            }
        return U3;
    }
     static class myThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(0);
                //System.out.println(Thread.currentThread().getName());
                ///可能存在的问题：在初始化成员变量之前将引用指向开辟的内存，此时变量还未赋值，可能出现问题
                System.out.println(getIntance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        //懒汉模式线程安全测试
       /* System.out.println(Util3.getIntance());
        System.out.println(Util3.getIntance());
        System.out.println(Util3.getIntance());
        System.out.println(Util3.getIntance());*/
       new Util3.myThread().start();
       new Util3.myThread().start();
       new Util3.myThread().start();
       new Util3.myThread().start();
       new Util3.myThread().start();
      /* Util3.myThread.currentThread().start();
       Util3.myThread.currentThread().start();
       Util3.myThread.currentThread().start();*/

    }


}

class Util4{
    private Util4() { }
    static class SignObject{
        private static Util4 U4 = new Util4();
    }
    public static Util4 getInstan(){

        //return Util4.SignObject.U4;
        return SignObject.U4;
    }

    public static void main(String[] args) {
        System.out.println(Util4.getInstan());
        System.out.println(Util4.getInstan());
        System.out.println(Util4.getInstan());
        System.out.println(Util4.getInstan());
        System.out.println(Util4.getInstan());
    }
}

class Student{
    String name="hshs";
    String sex;
    static int a=0;
    int age;
    Persion s = new Persion("kk");
    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public static void main(String[] args) {
        new Student("张三","男",20);
    }
}
class Persion{
    String name;

    public Persion(String name) {
        this.name = name;
    }
}
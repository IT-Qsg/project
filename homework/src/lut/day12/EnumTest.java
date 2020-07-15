package lut.day12;

import java.util.TreeSet;

public class EnumTest {
    public static void main(String[] args) {
        /*Util u1 = Util.show();
        Util u2 = Util.show();
        Util u3 = Util.show();
        Util u4 = Util.show();
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);*/
        /*Gender g1 = Gender.NAN;
        Gender g2 = Gender.NAN;
        Gender g3 = Gender.NAN;
        Gender g4 = Gender.NAN;
        Gender g5 = Gender.NAN;
        System.out.println(g1.getClass());
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(g4);
        System.out.println(g5);*/
        Gender g1 = Gender.NV;
        Gender g2 = Gender.NV;
        Gender g3 = Gender.NV;
        Gender g4 = Gender.NV;
        Gender g5 = Gender.NV;
        /*System.out.println(g1.getClass());
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(g4);
        System.out.println(g5);*/
//        g1.show();
//        g1.show(1);
//        g1.show1();
       // g1.show2();
        Gender.test();
    }
}
enum Gender implements abc{
    NAN("男"){
        @Override
        public void show1(){
            System.out.println("NAM show1方法");
        }
        public void show2(){
            System.out.println("show2 方法");
        }
    }, NV("女"){
        @Override
        public void show1(){
            System.out.println("NV show1方法");
        }
        public void show2(){
            System.out.println("show2 方法");
        }
    };
    Gender(String sex){
        this.sex = sex;
    }
    String sex;
    Integer a = 100;

    public void show() {
        System.out.println("show方法");
    }

    public void show(int x) {
        System.out.println("show   x方法");
    }
    public abstract void show1();
    /*public void show2(){
        System.out.println("show2 方法");
    }*/
    public static void test(){
        System.out.println("静态方法");
    }
}
interface abc{
    public void show2();
}
//单例模式常用于工具类
// 懒汉模式
/*class Util {
    private static Util u = null;

    private Util() {
    }

    public static Util show() {
        if (u == null) u = new Util();
        return u;
    }
}

//饿汉模式
class Tool {
    private static Tool TOOL = new Tool();

    private Tool() {
    }

    public static Tool show() {
        return TOOL;
    }
}*/
//饿汉模式
class  B{
    public static final B DB = new B();
    private B(){}
}

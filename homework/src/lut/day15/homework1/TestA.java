package lut.day15.homework1;

import java.math.BigDecimal;

public class TestA{
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.0");
        Application a = new Application(0);
        new A("1.0的线程",a,1.0).start();
        new B("0.1的线程",a,0.1).start();
    }
}
enum Lock{
    LOCK
}
 class Application{
    //synchronized(this){}
    private double x;
    public Application(double x){
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
class A extends  Thread{
    Application A;
    double x;
    double a;
    public A(String name,Application A,double x2){
        super(name);
        this.a=x2;
        this.A = A;
    }

    @Override
    public void run() {
        while(true){
            synchronized (Lock.LOCK) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                x=A.getX()+a;
                A.setX(x);
                System.out.println(name+"----------"+x);
            }
        }


    }
}
class B extends  Thread{
    Application A;
    double x;
    double a;
    public B(String name,Application A,double x2){
        super(name);
        this.a=x2;
        this.A=A;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (Lock.LOCK) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                x =A.getX()+a;
                A.setX(x);
                System.out.println(name+"--------"+x);
            }
        }

    }
}
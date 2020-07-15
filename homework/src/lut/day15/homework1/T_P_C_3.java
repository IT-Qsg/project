package lut.day15.homework1;

import java.util.LinkedList;
import java.util.List;

public class T_P_C_3 {
    public static void main(String[] args) {
        /*new PC3().start();
        new PC3().start();
        new PC3().start();*/
        SE se = new SE();
        Pro pro = new Pro(se);
        Cus cus = new Cus(se);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(cus,"窗口1");
        Thread t3 = new Thread(cus,"窗口2");
        t1.start();
        t2.start();
        t3.start();

    }
}
/*class PC3 extends Thread{

    @Override
    public void run() {
        while(true){
            List list = new SE().addP();
            for(int i = 0; i < list.size();i++){
                if(list.size()==0) {
                System.out.println("票已经卖完");
                break;
            }
                System.out.println(new SE().remo());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}*/
class SE{
    int i = 0;
    List list = new LinkedList<>();
//    int i = list.size();
    public synchronized List addP(){
            list.add(i+++"号票");
        this.notify();
        return list;
    }
    public synchronized Object remo(){
        while(list.size()==0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.notify();
            return list.remove(0);

    }
}
class Pro implements  Runnable{

    SE se = null;

    public Pro(SE se) {
        this.se = se;
    }

    @Override
    public void run() {
        //产票
        for(int i = 0;i<10;i++) {
            se.addP();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Cus implements Runnable{
    SE se = null;
    public Cus(SE se) {
        this.se = se;
    }
    @Override
    public void run() {
        //出票
        for(int i = 0;i<10;i++) {
            System.out.println(Thread.currentThread().getName()+"   "+se.remo());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 10)break;
        }
    }
}
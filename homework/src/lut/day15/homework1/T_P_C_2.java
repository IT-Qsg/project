package lut.day15.homework1;

import java.util.LinkedList;
import java.util.List;

public class T_P_C_2 {
    public static void main(String[] args) {
        new P2().start();
        new C2().start();
    }
}
class P2 extends  Thread{
    @Override
    public void run() {
            new PC().p();
    }
}
class C2 extends Thread{
    @Override
    public void run() {
        new PC().c();
    }
}
class PC{
    List<Object> list = new LinkedList<>();
    public synchronized void  p(){
        for(int i = 0;i<10;i++){
            list.add(i+"号票");
        }
        this.notify();
    }
    public synchronized void c(){
        while(list.size()==0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0;i<10;i++)
        System.out.println(list.remove(0));
        this.notify();

    }
}

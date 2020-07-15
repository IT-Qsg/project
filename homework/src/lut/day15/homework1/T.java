package lut.day15.homework1;

import java.util.LinkedList;
import java.util.List;

public class T{
    public static void main(String[] args) {
       // new P(new C().list).start();
       // new C(new P().list).start();
    }
}
class P extends  Thread{
    List<Object> list = new LinkedList<>();
    public P(List list){
        this.list = list;
    }

    public P() { }

    @Override
    public void run() {
        synchronized (list){
            for (int i = 0;i<100;i++){
                list.add(i+"号票");
            }
            list.notifyAll();

        }
    }
}
class C extends Thread{
    List<Object> list = new LinkedList<>();
    public C(List list){
        this.list = list;
    }
    public C() { }

    @Override
    public void run() {
        synchronized (list){
            if(list.size() == 0){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0;i<list.size();i++ ){
                System.out.println("该顾客是："+list.remove(i));
            }
            list.notifyAll();

        }

    }
}
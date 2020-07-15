package lut.day15.thread;

import static java.lang.Thread.sleep;

public  class ThteadTest {
    public static void main(String[] args) {
       /* MyThread myThread = new MyThread();
        myThread.start();

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
//        System.out.println(name);
        for (int i = 0;i<20;i++)
        System.out.println(name+"主方法打印的内容");*/

       //创建新线程要操作的目标
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2,"myThread2").start();

        String name = Thread.currentThread().getName();
        for(int x =0;x<10;x++){
            System.out.println(name+"  线程"+x);
        }

    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        String name =currentThread().getName();

        for (int i = 0;i<10;i++)
        System.out.println(name+"run fuction");
    }
}
class MyThread2 implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int x = 0;x<10;x++)
        System.out.println(name+"实现runanle接口的类"+x);
    }
}
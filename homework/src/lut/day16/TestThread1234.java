package lut.day16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread1234 {
    /*
    *
    * 四个线程1,2,3,4. 线程1,2对变量i加一. 线程3,4对变量i减去一.
    * 四个线程顺序执行, 每个线程每次只执行一次.
    * i的初始值为0， 打印结果0 1 2 1 0 1 2 1 0 1 2...
    * */
    public static void main(String[] args) {
        Thread1234 thread1234 = new Thread1234(0);
        Add add = new Add(thread1234);
        Sub sub = new Sub(thread1234);
      /*  new Thread(add).start();
        new Thread(add).start();
        new Thread(sub).start();
        new Thread(sub).start();*/
        Thread thread = new Thread(add);
        Thread thread1 = new Thread(add);
        Thread thread2 = new Thread(sub);
        Thread thread3 = new Thread(sub);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(thread);
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
    }

}
class Thread1234{
    /*Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition1 =lock.newCondition();*/
    int i;
    public Thread1234(int i) {

        this.i = i;
    }
     public  void add() throws InterruptedException {
        while(true)
        synchronized (this){
            Thread.sleep(1000);
            i++;
            System.out.print(i+"   ");
        }
    }
    public void sub() throws InterruptedException {
        while(true)
        synchronized(this){
            Thread.sleep(1000);
            i--;
            System.out.print(i+"   ");
        }
    }
}
class Add implements Runnable{
    private Thread1234  thread1234 ;
    Add(Thread1234 thread1234){
        this.thread1234 = thread1234;
    }
    @Override
    public void run() {
        try {
            thread1234.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Sub implements Runnable{
    private Thread1234  thread1234 ;
    Sub(Thread1234 thread1234){
        this.thread1234 = thread1234;
    }
    @Override
    public void run() {
        try {
            thread1234.sub();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

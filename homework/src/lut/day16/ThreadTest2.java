package lut.day16;

public class ThreadTest2 {
    Thread t1,t2, t3, t4;
    public static void main(String[] args) {
        new ThreadTest2().sss();
    }
    public void sss(){
        number number = new number();
        t1 = new Thread(()->{
            while (true){
                try {
                    number.add();t1.wait();
                    t2.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1addThread");
        t2 = new Thread(()->{
            while (true){
                try {
                    number.add();t2.wait();
                    t3.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T2addThread");
        t3 = new Thread(()->{
            while (true){
                try {
                    number.sub();  t3.wait();
                    t4.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T3addThread");
        t4 = new Thread(()->{
            while (true){
                try {
                    number.sub();t4.wait();
                    t1.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T4addThread");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class number{
    int i = 0;
    public  void add() throws InterruptedException {
                Thread.sleep(1000);
                i++;
                System.out.print(i+"   ");
        }
    public void sub() throws InterruptedException {
                Thread.sleep(1000);
                i--;
                System.out.print(i+"   ");
            }
    }
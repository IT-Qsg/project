package lut.day17.lockandlock;

public class LockAndLock {
    public static void main(String[] args) {
        new B().start();
        new C().start();
    }

}
enum  A{
    A1,A2
}
class  B extends Thread{
    @Override
    public void run() {
        synchronized (A.A1){
            String name = Thread.currentThread().getName();
            System.out.println(name+"锁A1");
            synchronized (A.A2){
                System.out.println(name+"锁A2");
            }
        }
    }
}class  C extends Thread{
    @Override
    public void run() {
        synchronized (A.A2){
            String name = Thread.currentThread().getName();
            System.out.println(name+"锁A2");
            synchronized (A.A1){
                System.out.println(name+"锁A1");
            }
        }
    }
}
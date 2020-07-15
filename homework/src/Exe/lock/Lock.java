package Exe.lock;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/10/7 20:13
 * @describe 不可重入锁
 **/
public class Lock {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized  void unlock(){
        isLocked = false;
        notify();
    }
}
class Count{
    Lock lock = new Lock();
    public void print() throws InterruptedException {
        lock.lock();
        System.out.println("print获得锁后执行");
        exe();
        lock.unlock();
    }
    public void exe() throws InterruptedException {
        lock.lock();
        System.out.println("exe获得锁后执行");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        c.print();
        c.exe();
    }

}
/*我们设计两个线程调用print()方法，第一个线程调用print()方法获取锁，
进入lock()方法，由于初始lockedBy是null，所以不会进入while而挂起当前线程，
而是是增量lockedCount并记录lockBy为第一个线程。接着第一个线程进入doAdd()方法，
由于同一进程，所以不会进入while而挂起，接着增量lockedCount，
当第二个线程尝试lock，由于isLocked=true,所以他不会获取该锁，
直到第一个线程调用两次unlock()将lockCount递减为0，才将标记为isLocked设置为false。
* */
 class Lock2{
    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedCount = 0;
    public synchronized void lock()
            throws InterruptedException{
        Thread thread = Thread.currentThread();
        while(isLocked && lockedBy != thread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}

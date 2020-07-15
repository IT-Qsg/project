package lut.day15.homework1;

public class T_P_C_4 implements Runnable{
    private final String LOCK;
    private int init=1 ;
    private int pNum;
    T_P_C_4(int pNum,String LOCK){
        this.LOCK = LOCK;
        this.pNum = pNum;
    }

    @Override
    public void run() {
        while(true){
            synchronized (LOCK){
                if(init>pNum){
                    System.out.println("票卖完");
                    return;
                }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售出::"+ init++);
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        T_P_C_4 lock = new T_P_C_4(10, "LOCK");
        new Thread(lock,"A窗口").start();
        new Thread(lock,"B窗口").start();
        new Thread(lock,"C窗口").start();
        new Thread(lock,"D窗口").start();
    }
}
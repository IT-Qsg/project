package lut.day16;

public class TestP extends  Thread{


    public TestP(String name){
        super(name);
    }
    public void  selectP() throws InterruptedException {
//        Class<? extends TestP> aClass = this.getClass();
//       System.out.println(aClass);
        synchronized (c.C){
        String name = Thread.currentThread().getName();
        if(i>0){
            sleep(10);
        System.out.println(name+"售出了"+i--);}
      //  this.i=i;
       }
    }
    private static int i = 100;
    @Override
    public void run() {
        while(true){
            try {
                this.selectP();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class d{
    public static void main(String[] args) {
        new TestP("线程1").start();
        new TestP("线程2").start();
        new TestP("线程3").start();
    }
}
enum c{
    C
}

class saletun implements Runnable{
    int i = 100;

    @Override
    public void run() {
        while(i>0) {
            this.saleTicket();
        }
    }

    private  void saleTicket() {
        synchronized (this){
        if(i>0){
        String name = Thread.currentThread().getName();
        System.out.println(name+"  "+i--);
        }
    }
    }

}
class TestSa{
    public static void main(String[] args) {
        saletun saletun = new saletun();
        new Thread(saletun,"线程1").start();
        new Thread(saletun,"线程2").start();
        new Thread(saletun,"线程3").start();
    }
}
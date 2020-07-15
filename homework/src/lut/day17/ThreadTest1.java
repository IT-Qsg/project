package lut.day17;

public class ThreadTest1 {
    public static void main(String[] args) {
        AddAndSub addAndSub = new AddAndSub(0);
        Add add = new Add(addAndSub);
        Sub sub = new Sub(addAndSub);
        Add2 add2 = new Add2(addAndSub);
        Sub2 sub2 = new Sub2(addAndSub);
        new Thread(add,"Thread 1").start();
        new Thread(add2,"Thread 2").start();
        new Thread(sub,"Thread 3").start();
        new Thread(sub2,"Thread 4").start();
    }
}
class AddAndSub{
    int flage = 1;
    private int i;
    public AddAndSub(int i) {
        this.i = i;
    }

    public void Add1(){
        synchronized (this){
            if(flage==1){
                //System.out.print(i+"    ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                System.out.print(i+"    ");
                flage = 2;
                this.notifyAll();
            }else{
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void Add2(){
        synchronized (this){
            if(flage==2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                System.out.print(i+"    ");
                flage = 3;
                this.notifyAll();
            }else{
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }public void Sub1(){
        synchronized (this){
            if(flage==3){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
                System.out.print(i+"    ");
                flage = 4;
                this.notifyAll();
            }else{
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }public void Sub2(){
        synchronized (this){
            if(flage==4){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
                System.out.print(i+"    ");
                flage = 1;
                this.notifyAll();
            }else{
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Add implements Runnable{
    AddAndSub aas;
    public Add(AddAndSub aas){
        this.aas = aas;
    }
    @Override
    public void run() {
        while(true){
            aas.Add1();
        //    aas.Add2();
        }
    }
}class Add2 implements Runnable{
    AddAndSub aas;
    public Add2(AddAndSub aas){
        this.aas = aas;
    }
    @Override
    public void run() {
        while(true){
            //aas.Add1();
           aas.Add2();
        }
    }
}class Sub implements Runnable{
    AddAndSub aas;
    public Sub(AddAndSub aas){
        this.aas = aas;
    }
    @Override
    public void run() {
        while(true){
            aas.Sub1();
          //  aas.Sub2();
        }
    }
}class Sub2 implements Runnable{
    AddAndSub aas;
    public Sub2(AddAndSub aas){
        this.aas = aas;
    }
    @Override
    public void run() {
        while(true){
           // aas.Sub1();
            aas.Sub2();
        }
    }
}
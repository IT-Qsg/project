package lut.day15.homework1;

public class TestB {
    public static void main(String[] args) {
        productNumAndABC productNumAndABC = new productNumAndABC();
        pNum pNum = new pNum(productNumAndABC);
        pABC pABC = new pABC(productNumAndABC);
        pNum.start();
        pABC.start();
    }

}
class productNumAndABC{

    public synchronized void proNum(){
        for(int i = 1;i<=52;i++){
            System.out.print(i);
            if (i%2==0) {
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized void priABC(){

        for(char i= 'A';i<='Z';i++){
            System.out.println(i);
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class pNum extends Thread{
    productNumAndABC p;
    public pNum(productNumAndABC p){
        this.p = p;
    }
    @Override
    public void run() {
        p.proNum();
    }
}
class pABC extends Thread{
    productNumAndABC p;
    public pABC(productNumAndABC p){
        this.p = p;
    }
    @Override
    public void run() {
        p.priABC();
    }
}
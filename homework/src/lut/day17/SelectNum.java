package lut.day17;

import java.util.Arrays;
import java.util.Random;

public class SelectNum {
    /*
    * 有一个抽奖池,该抽奖池中存放了奖励的金额,
    * 该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，
    * 随机从arr数组中获取奖项元素并打印在控制台上
    * */

    public static void main(String[] args) {
        int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
        SelectArrayNum selectArrayNum = new SelectArrayNum(arr);
        new C1(selectArrayNum,"抽奖框1：：").start();
        new C2(selectArrayNum,"抽奖框2：：").start();

    }

}
class SelectArrayNum{
    int[] arr ;

    public SelectArrayNum(int[] arr) {
        this.arr = arr;
    }

    /*
    * 删除数组中的某一个数
    * */
    public int sNUM(){
        if(arr.length!=0){
            int index = new Random().nextInt(arr.length);
            int num = arr[index];
            int[] ints = Arrays.copyOfRange(arr, 0, index);
            int[] ints1 = Arrays.copyOfRange(arr, index+1, arr.length);
            int[] ints2 = new int[ints.length+ints1.length];
            System.arraycopy(ints,0,ints2,0,ints.length);
            System.arraycopy(ints1,0,ints2,ints.length,ints1.length);
            arr = ints2;
            return num;
        }else
            return (-1);
    }
}
class C1 extends Thread{
    int i;
    SelectArrayNum selectArrayNum;
    C1(SelectArrayNum selectArrayNum,String name){
        super(name);
        this.selectArrayNum = selectArrayNum;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (selectArrayNum) {
                i=selectArrayNum.sNUM();
                if(i==-1)break;
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
class C2 extends  Thread{
    int i;
    SelectArrayNum selectArrayNum;
    C2(SelectArrayNum selectArrayNum,String name){
        super(name);
        this.selectArrayNum = selectArrayNum;
    }
    @Override
    public void run() {
        synchronized (selectArrayNum){
            while(true) {
                synchronized (selectArrayNum) {
                    i=selectArrayNum.sNUM();
                    if(i==-1)break;
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }
    }
}


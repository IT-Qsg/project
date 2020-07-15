package Exe.threadEx;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *               有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组
 *              int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 *              创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，
 *              随机从arr数组中获取奖项元素并打印在控制台上
 *
 * */
public class ChouJiang1 {
    public static void main(String[] args) {
        ExecutePro executePro = new ExecutePro();
        new Thread(executePro,"抽奖池1").start();
        new Thread(executePro,"抽奖池2").start();
    }

}
class ExecutePro implements Runnable{
    int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    int length = arr.length;
    List<Integer>  list=new ArrayList<>();
    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(list.size()==length)
                    return;
                int index = new Random().nextInt(arr.length);
                int value = arr[index];
                if(!list.contains(index)){
                    list.add(index);
                    System.out.println(Thread.currentThread().getName()+"::"+value);
            }
            }
        }
    }
}
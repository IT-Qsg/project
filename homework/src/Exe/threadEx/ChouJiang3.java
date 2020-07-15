package Exe.threadEx;

public class ChouJiang3 {
    /*
     *               有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组
     *              int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
     *              创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，
     *              随机从arr数组中获取奖项元素并打印在控制台上
     *
     * */

    public static void main(String[] args) {
        ExeChou exeChou = new ExeChou();
        new Thread(exeChou,"抽奖池1").start();
        new Thread(exeChou,"抽奖池2").start();
    }
}
class ExeChou implements Runnable{
      int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
      boolean[] flag = new boolean[arr.length];//默认元素的值为false
      int count=arr.length;

    @Override
    public void run() {
        while(count!=0){
            synchronized (this){
                int index = (int)(Math.random() * arr.length);
                if(flag[index]!=true){
                    flag[index]=true;
                    count--;
                System.out.println(Thread.currentThread().getName()+"::"+arr[index]);
                }
            }
        }

    }
}

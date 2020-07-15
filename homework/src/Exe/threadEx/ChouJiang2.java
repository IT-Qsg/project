package Exe.threadEx;

import java.util.ArrayList;
import java.util.List;

//线程不安全
public class ChouJiang2 {

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300};

        List<Object> list = new ArrayList<>(arr.length);
        for (Object s : arr) {
            list.add(s);
        }

        new Thread("抽奖箱1"){
            @Override
            public void run() {
                while (list.size()>0) {
                    int index = (int) (Math.random() * list.size());
                    Object o = list.get(index);
                    list.remove(index);
                    System.out.println(getName()+ "........" + o);
                }
            }
        }.start();

        new Thread("抽奖箱2"){
            @Override
            public void run() {
                while (list.size() > 0) {
                    int index = (int) (Math.random() * list.size());
                    Object o = list.get(index);
                    list.remove(index);
                    System.out.println(getName() + "........" + o);
                }
            }
        }.start();

    }
}

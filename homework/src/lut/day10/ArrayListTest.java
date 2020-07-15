package lut.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ArrayListTest {
    public static void main(String[] args) {
        List list = new ArrayList<Object>();
        list.add("你好");
        list.add(10);
        list.add(true);
        System.out.println(list);
       /* for(int i = 0;i<list.size();i++){
            Object o = list.get(i);
            if(o.equals(10)){
                list.remove(i);
              //  list.remove(Integer.valueOf(10));
            }
        }*/
        System.out.println(list);
        list.forEach(o-> System.out.println(o));
        list.forEach(System.out::println);
        System.out.println("----------------------------");
        list.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        Iterator iterator = list.iterator();
      //  ListIterator listIterator = list.listIterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            if(o.equals(10)){
               // list.add(100);//ConcurrentModificationException并发修改异常
            }
        }

    }
}

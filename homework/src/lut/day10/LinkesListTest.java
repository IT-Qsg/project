package lut.day10;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkesListTest {
    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();//时间戳
        LinkedList linkedList = new LinkedList();
        linkedList.add("TestLinkedList");
        for(int i = 0;i <100;i++){
            linkedList.add(0,"Test");
        }
        Long t2 = System.currentTimeMillis();//时间戳
        System.out.println("t2-t1:"+(t2-t1));

        Long t3 = System.currentTimeMillis();//时间戳
        ArrayList arrayList = new ArrayList();
        arrayList.add("TestArrayList");
        for(int i = 0;i <100;i++){
            arrayList.add(0,"Test");
        }
        Long t4 = System.currentTimeMillis();//时间戳
        System.out.println("t4-t3:"+(t4-t3));
    }

}

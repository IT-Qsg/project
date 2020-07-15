package lut.day5.exe4.exe4_7;

public class ExtendsTest3 extends X {
     //成员变量(引用类型)
    Y y = new Y();
     //无参构造方法
     ExtendsTest3() {
         //super(); //它仅仅表示要先初始化父类数据，再初始化子类数据。
         System.out.print("Z");
     }
     public static void main(String[] args) {
         new ExtendsTest3(); 
     }
 }
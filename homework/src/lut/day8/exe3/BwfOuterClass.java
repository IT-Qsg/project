package lut.day8.exe3;

public class BwfOuterClass {
      private int x = 1;
      private int y = 2;
      private class BwfInnerClass{
      	   private int x = 3;
           public void print(){
               System.out.println("我爱学习:x+y="+(x+y) );
           }
      }
      public static void main(String[] args) {
          new BwfOuterClass().new BwfInnerClass().print();
      }
}
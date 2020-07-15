package lut.day8.exe1;

public class A {
    int i = 10;
    public void show(){
        int a= 0;
        class B{
           int a = 100;
           public void show(){
               int a = 10;
               System.out.println(this.a);
           }
        }
    new B().show();
    }

    public static void main(String[] args) {
        A a = new A();
        a.show();
    }
}

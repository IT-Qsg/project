package lut.day7;

public class MyClassStatic {
    static int count;
    MyClassStatic(){
        System.out.println("第"+ ++count +"个对象");
    }
    public static void main(String[] args) {
        new MyClassStatic();
        new MyClassStatic();
        new MyClassStatic();
        new MyClassStatic();

    }
}

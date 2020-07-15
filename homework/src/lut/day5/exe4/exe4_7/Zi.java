package lut.day5.exe4.exe4_7;

class Zi extends Fu {
     static {
         System.out.println("静态代码块Zi");
     }
     public Zi() {

         System.out.println("构造方法Zi");
     }
    {
        System.out.println("构造代码块Zi");
    }
 }
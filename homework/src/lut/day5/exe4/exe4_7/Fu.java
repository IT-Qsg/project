package lut.day5.exe4.exe4_7;

class Fu {
     static {
         System.out.println("静态代码块Fu");
     }
 
     {
         System.out.println("构造代码块Fu");
     }
 
     public Fu() {
         System.out.println("构造方法Fu");
     }
 }
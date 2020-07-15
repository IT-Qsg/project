package lut.day6;

public class Z_day6_4 {
    int num = 8;
    class A {
        int num = 7;

        public void a() {
            int num = 6;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Z_day6_4.this.num);
        }
    }
    static int d = 10;
       static class B{
            int num = 3;
            public void a(){
                int num = 2;
                System.out.println(num);
                System.out.println(this.num);
                System.out.println(Z_day6_4.d);
            }
     }
     public void D(){
     }
     public static  void main(String [] arge){
         Z_day6_4.A a = new Z_day6_4().new A();//非静态内部类通过对象调用
         a.a();
         Z_day6_4.B b = new Z_day6_4.B();//静态内部类（相当于一个静态成员，通过类名调用）
         b.a();
         Z_day6_4 z = new Z_day6_4();
     }
}

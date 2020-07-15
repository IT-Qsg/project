package lut.day23.exe;

import java.util.function.Function;

public class FuctionTest {
    public static void main(String[] args) {
        //Function<String,String> f1 = X::show;
        Function<String,String> f1 =new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(this+"   <--1");
                return X.show(s);
            }
        };
        /*//String apply = f.apply("123");
        //System.out.println(apply);
        Function<String,String> f11 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return X.show(s);
            }
        };*/
        Function<Object, String> f2 = f1.compose(new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                System.out.println(f1+"    f1");
                System.out.println(this+"   <--2");
                return ":" + o.toString();
            }
        }.compose(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                System.out.println("最后");
                return "o+o+O+O+O+o+o"+o.toString();
            }
        }));
       // System.out.println(f1);
     //   Function<Object, String> f2 = f1.compose(new A());
       // System.out.println(f2+"    f2");
        String apply = f2.apply(new X());
        //System.out.println(f2+"    f2");
        System.out.println(apply);
    }
}
class X{
    static String show(String s){
        return s+"<--H-->"+s;
    }
}
//:java.lang.Object@214c265e
class A implements Function<Object, String>{
    @Override
    public String apply(Object o) {
       return  ":" + o.toString();
    }
}
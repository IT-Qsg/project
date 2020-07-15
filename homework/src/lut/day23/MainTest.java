package lut.day23;

import java.rmi.RemoteException;
import java.util.function.Function;

public class MainTest{
    public static void main(String[] args) throws RemoteException{
        class MyFun1 implements Function<String,String>{
            @Override
            public String apply(String s){
                System.out.println(this+"     <-------1");
                return X.show(s);
            }
        }
        Function<String,String> f1=new MyFun1();

        class MyFunX implements Function<Object,String>{
            @Override
            public String apply(Object o){
                System.out.println(f1+"       f1    ,,,,,,,");
                System.out.println(this+"     <-------2");
                return ":"+o.toString();
            }
        }

        MyFunX fx=new MyFunX();

        Function<Object,String> f2=f1.compose(fx);

        System.out.println(f2+"       f2     ///////////////");
        String apply=f2.apply(new X());
        System.out.println(f2+"       f2    ");
        System.out.println(apply);
    }
}

class X{
    static String show(String s){
        return s+":"+s;
    }
}

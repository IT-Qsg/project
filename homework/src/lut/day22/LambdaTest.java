package lut.day22;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("债那个三");
        list.add("李那个三");
        list.add("王那个三");
        list.add("照那个三");
        for (String s : list) {
            System.out.println(s);
        }
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
interface E extends C{}
interface C{}
class B implements E{}
class F extends B implements C,E{}
class D extends  B{}
class A<T extends B&C>{
    public static void main(String[] args) {

    }
    public void s(){
        A<B> ba = new A<>();
    }
}

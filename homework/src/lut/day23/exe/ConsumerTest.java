package lut.day23.exe;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<String> con  = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(this);
                System.out.println(s);
            }
        };
        Consumer<String> stringConsumer = con.andThen(con);
        System.out.println(con+"---------");
        stringConsumer.accept("jjj");
    }
}

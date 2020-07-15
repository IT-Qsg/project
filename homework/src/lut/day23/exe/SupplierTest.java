package lut.day23.exe;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return new String();
            }
        };
        Supplier<String> sup = String::new;
    }
}

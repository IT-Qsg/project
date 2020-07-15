package lut.day23.exe;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> pr =new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(s+"------------>pr");
                return s.equals("123");
            }
        };

//        Predicate<String> pr2 =s->s.equals("123");
//        Predicate<String> and2 = pr.and(pr2);
//        boolean bo2 = and2.test("123");
//        System.out.println(bo2);

        //Predicate<String> pr3 =s-> s.equals("234");//不是pr3实现的test方法，是匿名子类实现的，pr3只是一个父类引用
        Predicate<String> pr3 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(s+"--------->pr3");
                return s.equals("123");
            }
        };
        Predicate<String> and3 = pr.and(pr3.and(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(s+"---------》匿名");
                return s.equals("123");
            }
        }.and(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(s+"-------------------》最后");
                return s.equals("123");
            }
        })));
        boolean bo3 = and3.test("123");
        System.out.println(bo3);
        //boolean test = pr3.test("456");
        //System.out.println(test);

        Predicate<String> negate1 = pr.negate();
        boolean test1 = negate1.test("456");
        System.out.println(test1);
        Predicate<String> negate = negate1;
        boolean test = negate.test("123");
        System.out.println(test);

       // Predicate<String> pc = Objects::isNull;
        Object o = null;
        Predicate<Object> equal = Predicate.isEqual(o);
        System.out.println(equal.test(o));
        Object o2 = new Object();
        Predicate<Object> equal2 = Predicate.isEqual(o2);
        System.out.println(equal2.test(new String()));


    }
}

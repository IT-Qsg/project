package lut.day23.exe;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {
    public static void main(String[] args) {
        //不能创建无参构造器，内部构造器是私有的
       // Optional<String> opt1 = new Optional<>();

        //构造无参构造器
        Optional<String> opt2 = Optional.empty();
        //构造一个参数的构造器
        Optional<Object> o = Optional.of(new Object());

        Person p = new Person();

        Optional<Person> p1 = Optional.ofNullable(p);

        if(p1.isPresent()){
            Person person = p1.get();
            System.out.println(person);
        }
        p1.ifPresent(s->{
            s.name = "张三";
        });
        System.out.println(p.name);

        Optional<Person> p2 = p1.filter(s -> s.name.equals("张三"));
        System.out.println(p1 +"  ======   "+p2);

        /*Optional<String> s = p1.map(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.name;
            }
        });*/
        Optional<String> s = p1.map(sn -> sn.name);
        System.out.println("------------------------");
        s.ifPresent(System.out::println);

        /*Optional<String> s1 = p1.flatMap(new Function<Person, Optional<String>>() {
            @Override
            public Optional<String> apply(Person person) {

                return Optional.ofNullable(person.name);
            }
        });*/
        Optional<Person> person = p1.flatMap(Optional::ofNullable);//传什么，返回什么
        Optional<String> s1 = p1.flatMap(ss -> Optional.ofNullable(ss.name));//传Person返回Person的name
        s1.ifPresent(System.out::println);
        System.out.println("****************************************");
        Optional<Object> o1 = Optional.ofNullable(null);
        System.out.println(o1);

        Object o2 = o1.orElseGet(Person::new);
        System.out.println(o2);
    }
}
class Person{
    String name;
}
class Student extends  Person{}
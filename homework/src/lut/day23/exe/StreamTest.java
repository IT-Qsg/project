package lut.day23.exe;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String data = "1234567890)(*&^%$#@!qwertyuioplkjhgfdsazxcvbnm,./";
        List<String> list = new LinkedList<>();
        Random  r = new Random();
        for (int i = 0; i<1000;i++){
            StringBuilder sb = new StringBuilder();

            int max = r.nextInt(50);
            for (int j = 0 ; j <max;j++){
                int dat = r.nextInt(data.length());
                sb.append(data.charAt(dat)+"-");
            }
            list.add(sb.toString()+"  ---------->>  "+i);
        }
        list.forEach(System.out::println);

        System.out.println("########################################");
        Stream<String> stream = list.stream();
        boolean b = stream.filter(s -> s.length() == 30 && s.length() > 10)
                .allMatch(s->s.length()==30);
               // .anyMatch(s -> s.length() == 20);
        System.out.println(b);
        //.forEach(System.out::println);
        //System.out.println(count);
    }
}

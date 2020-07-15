package lut.day18.homework;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class H2 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader bufferedReader =
                new BufferedReader(
                        new FileReader("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\递归和File作业.txt"));
        BufferedReader bufferedReader2 =
                new BufferedReader(
                        new FileReader("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\递归和File作业.txt"));
        while(true) {
            int read = bufferedReader.read();
            if(read==-1)break;
            set.add(read);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer : set) {
            map.put(integer,0);
        }
        while(true){
            int read = bufferedReader2.read();
            if(read==-1)break;
            if(set.contains(read))
            {
                //System.out.println(read);
                Integer integer = map.get(read);
                map.put(read,++integer);
            }
        }
        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\count.txt"));
        map.forEach(new BiConsumer<Integer, Integer>() {
              int i = 0;
              @Override
              public void accept(Integer in1, Integer in2) {
                      try {bufferedWriter.write(in1);
                          bufferedWriter.write("---->>"+in2+"  ");
                          if(i++%10==0) {bufferedWriter.write("\n");}
                          bufferedWriter.flush();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
              }
          }
              /*(in1,in2)->{
          int i=0;
            try {
                bufferedWriter.write(in1);
                bufferedWriter.write(" >> "+in2);
                if(i++%10==0) bufferedWriter.write("\n");
                bufferedWriter.flush();
                System.out.println(in1+"::::"+in2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/);

    }
}
/*class test{
    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\count.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\递归和File作业反向写入.txt"));

        bufferedWriter.write("你好",0,2);
    }
}*/
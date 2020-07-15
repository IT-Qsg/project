package lut.day18.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class H1 {
    public static void main(String[] args) throws IOException {
        List<String>  list = new ArrayList<>();
        File file = new File("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\递归和File作业.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s;
        while((s = bufferedReader.readLine())!=null){
            list.add(s);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\递归和File作业反向写入.txt"));
       for(int i=list.size();i>0;i--){
            String s1 = list.get(i - 1);
            bufferedWriter.write(s1+"\n");

        }
        String s2 = list.get(list.size() - 1);
        String s3 = list.get(0);
        list.set(list.size() - 1,s3);
        list.set(0,s2);
        for(int i=0;i<list.size();i++){

            String s1 = list.get(i);
            bufferedWriter.write(s1+"\n");

        }
        bufferedWriter.close();
        bufferedReader.close();

    }
}

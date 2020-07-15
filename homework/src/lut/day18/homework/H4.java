package lut.day18.homework;

import java.io.*;

public class H4 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =
                new BufferedInputStream(
                        new FileInputStream("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\a.txt"));

      byte[] bytes = new byte[5];
      int flage;
        while((flage=inputStream.read(bytes))!=-1){
            String data = new String(bytes,0,flage);
            System.out.println(data);
        }
    }
}

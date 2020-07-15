package lut.day19;

import jdk.internal.dynalink.beans.StaticClass;

import java.io.*;

public class ReadANDWrite {
    public static void main(String[] args) throws IOException {
      //  test();
        testRead();
    }
    static void test() throws IOException {
        OutputStreamWriter osw =
                new OutputStreamWriter
                        (new FileOutputStream("C:\\Users\\qsg\\Desktop\\a.txt"),"GBK");
        osw.write("你好");
        osw.write("你好");
        osw.write("你好");
        osw.write("你好");
        osw.write("你好");
        osw.close();

    }
    static void testRead() throws IOException {
        InputStreamReader ins =
                new InputStreamReader(
                        new FileInputStream("C:\\Users\\qsg\\Desktop\\a.txt"),"GBK");
        int read;
        while((read = ins.read())!=-1){
            System.out.println((char)read);
        }
    }
}


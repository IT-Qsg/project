package Exe.collection;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pr = new Properties();
        pr.setProperty("张三","123");
        pr.setProperty("李四","123");
        pr.setProperty("王五","123");
        pr.setProperty("赵六","123");
        //pr.list(new PrintStream(new FileOutputStream("D:\\ideaIU\\project\\homework\\src\\Exe\\collection\\c.txt")));
        //System.out.println(pr);
        Properties pr2 = new Properties();
        pr2.load(new FileReader("D:\\ideaIU\\project\\homework\\src\\Exe\\collection\\c.txt"));
        System.out.println(pr2);
    }
}

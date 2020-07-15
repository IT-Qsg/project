package lut.day26;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public  static void log(String info) throws FileNotFoundException {
        PrintWriter log = new PrintWriter(new FileOutputStream("E:\\a.log", true), true);
        Date date = new Date();
        // String s = date.toString();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss S");
        String format = sd.format(date);
        log.println("【"+format+"】："+info);
        log.close();

    }
}

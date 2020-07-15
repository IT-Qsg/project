package lut.day24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpdateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String datF = "yyyy-MM-dd HH:mm:ss S a F W E";
        SimpleDateFormat sd = new SimpleDateFormat(datF);
        String s = sd.format(date);
        System.out.println(s);

        SimpleDateFormat sd2 = new SimpleDateFormat();
        sd2.applyPattern("yyyy.MM.dd HH.mm.ss S");
        Date parse = sd2.parse("1995.03.20 10.16.03 150");
        System.out.println(parse.toString());

    }
}

package lut.day17;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        String property = System.getProperty("file.separator");
        String separator = File.separator;
        char separatorChar = File.separatorChar;
        String pathSeparator = File.pathSeparator;
        char pathSeparatorChar = File.pathSeparatorChar;
        System.out.println(property+"  "+separator+"  "+separatorChar+"  "+pathSeparator+"  "+pathSeparatorChar);
    }
}

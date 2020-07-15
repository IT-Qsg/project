package sever1.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperFindder {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\sever1\\config\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public String getValudOf(String key){
        return properties.getProperty(key);
    }
}

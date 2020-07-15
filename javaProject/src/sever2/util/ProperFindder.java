package sever2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperFindder {
    private static Properties properties;
    private static Properties propertiesmime;
    private static Properties propertiesstatus;
    static {
        properties = new Properties();
        propertiesmime = new Properties();
        propertiesstatus = new Properties();
        try {
            properties.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\sever2\\config\\config.properties"));
            propertiesmime.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\sever2\\resource\\proper\\mime.properties"));
            propertiesstatus.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\sever2\\resource\\proper\\status_code.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public String getValudOf(String key){
        return properties.getProperty(key);
    }
    static public String getValudOfmime(String key){
        return propertiesmime.getProperty(key);
    }
    static public String getValudOfstatus(String key){
        return propertiesstatus.getProperty(key);
    }
}

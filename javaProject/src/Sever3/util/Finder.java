package Sever3.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Finder {
    private static Properties propertiesconfig;
    private static Properties propertiesmime;
    private static Properties propertiesstatus;
    static {
        propertiesconfig = new Properties();
        propertiesmime = new Properties();
        propertiesstatus = new Properties();
        try {
            propertiesconfig.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\Sever3\\config\\config.properties"));
            propertiesmime.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\Sever3\\config\\mime.properties"));
            propertiesstatus.load(new FileInputStream("D:\\ideaIU\\project\\javaProject\\src\\Sever3\\config\\status_code.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public String getValudOf(String key){
        return propertiesconfig.getProperty(key);
    }
    static public String getValudOfmime(String key){
        return propertiesmime.getProperty(key);
    }
    static public String getValudOfstatus(String key){
        return propertiesstatus.getProperty(key);
    }
}

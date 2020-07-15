package Util.finder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Finder {
    private static Properties propertiesconfig;
    private static Properties propertiesmime;
    private static Properties propertiesstatus;
    private static Properties propertiesservlet;
    static {
        propertiesconfig = new Properties();
        propertiesmime = new Properties();
        propertiesstatus = new Properties();
        propertiesservlet = new Properties();
        try {
            propertiesconfig.load(new FileInputStream("D:\\ideaIU\\project\\ServerProject\\src\\server_config\\config.properties"));
            propertiesmime.load(new FileInputStream("D:\\ideaIU\\project\\ServerProject\\src\\server_config\\mime.properties"));
            propertiesstatus.load(new FileInputStream("D:\\ideaIU\\project\\ServerProject\\src\\server_config\\status_code.properties"));
            propertiesservlet.load(new FileInputStream("D:\\ideaIU\\project\\ServerProject\\src\\server_config\\servlet.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public String getValudOfconfig(String key){
        return propertiesconfig.getProperty(key);
    }
    static public String getValudOfmime(String key){
        return propertiesmime.getProperty(key);
    }
    static public String getValudOfstatus(String key){
        return propertiesstatus.getProperty(key);
    }
    static public String getValudOfServlet(String key){
        return propertiesservlet.getProperty(key);
    }
}

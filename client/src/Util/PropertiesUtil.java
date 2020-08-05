package Util;

import java.io.*;
import java.util.Properties;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname PropertiesUtil
 * @Date 2020/7/22 9:38
 * @Copyright DFEC
 **/
public class PropertiesUtil {
    private static  final  String PATH = "D:\\ideaIU\\project\\client\\src\\pathconf.properties";
    /*
    根据文件名加载Properties   (读取配置文件路径)
    */
    public static String readPath(String fileName)  {
        Properties properties = new Properties();
        InputStreamReader ir = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(PATH);
            ir = new InputStreamReader(fin,"utf-8");
            properties.load(ir);
            //对应的配置文件路径
            String property = properties.getProperty(fileName);
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ir!=null){
                try {
                    ir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fin!=null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean writeProperties(String filePath,Properties propertie){
        Properties properties = propertie;
//        Properties properties1 = new Properties();

        OutputStreamWriter ow = null;
        FileOutputStream fo = null;
        try {

            fo = new FileOutputStream(filePath);
            ow = new OutputStreamWriter(fo,"utf-8");
            properties.store(ow,null);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ow!=null){
                try {
                    ow.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

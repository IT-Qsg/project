package sever2.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    public static  Logger logger (){
        PropertyConfigurator.configure("src//propertiesConfig//log4j.properties");
      return Logger.getLogger(Log.class.getName());
    }
}

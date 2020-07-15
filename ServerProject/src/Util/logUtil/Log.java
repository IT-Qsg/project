package Util.logUtil;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    public static Logger logger (){
        PropertyConfigurator.configure("src/log_config/log4j.properties");
      return Logger.getLogger(Log.class.getName());
    }
}

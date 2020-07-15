package com.dfec.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 13:38
 * @describe
 **/
public class Log {
    static {
        PropertyConfigurator.configure("D:\\ideaIU\\project\\springStu\\src\\com\\dfec\\conf\\log4j.properties");
    };
    public final static Logger logger = Logger.getLogger(Log.class.getName());
}

package com.dfec.impala;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MyFunction
 * @Date 2020/7/27 14:32
 * @Copyright DFEC
 **/
public class MyFunction extends UDF {
    public String evaluate(String phone){
        String ph = phone.substring(0, 3);
        if("138".equals(ph)){
            return "上海";
        }else if ("139".equals(ph)){
            return "兰州";
        }else if ("133".equals(ph)){
            return "杭州";
        }else if ("132".equals(ph)){
            return "北京";
        }
        return "未知";
    }
}

package com.dfec.bean_extends;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 16:41
 * @describe
 **/
public class Customer {
    private  String type;
    private String ation;
    private String con;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAtion() {
        return ation;
    }

    public void setAtion(String ation) {
        this.ation = ation;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "type='" + type + '\'' +
                ", ation='" + ation + '\'' +
                ", con='" + con + '\'' +
                '}';
    }
}

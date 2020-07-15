package com.dfec.date;

import java.util.Date;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 14:23
 * @describe
 **/
public class Customer {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "date=" + date +
                '}';
    }
}

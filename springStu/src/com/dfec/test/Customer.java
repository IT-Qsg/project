package com.dfec.test;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 13:15
 * @describe
 **/
public class Customer {
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "list=" + list +
                '}';
    }
}

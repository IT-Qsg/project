package com.dfec.flink.table.Table_java;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname a
 * @Date 2020/7/31 15:39
 * @Copyright DFEC
 **/
public class a{
    String name;
    int  id;

    public a(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public a() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "a{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

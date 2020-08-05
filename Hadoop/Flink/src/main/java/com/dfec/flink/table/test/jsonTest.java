package com.dfec.flink.table.test;


import com.alibaba.fastjson.JSON;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname jsonTest
 * @Date 2020/7/31 9:19
 * @Copyright DFEC
 **/
public class jsonTest {
    public static void main(String[] args) {
       // JSONArray json = new JSONArray(); //->List
       // JSONObject jo = new JSONObject(); //->Map

      //  ArrayList<String> arr = new ArrayList<>();
        /*arr.add("test");
        arr.add("test2");
        json.addAll(arr);*/
       // json.add("{'1':test}");
       // json.add(0,"wrewr");
        p P= JSON.parseObject("{'id':'12','name':'333'}", p.class);

        String s = P.toString();
        System.out.println(s);
      //  System.out.println(json);
        p p2 = new p(1, "ceshi");

        String s1 = JSON.toJSONString(p2);
        System.out.println(s1);

    }
}
class p{
    private int id;
    private String name;
    public p() {
    }

    public p(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
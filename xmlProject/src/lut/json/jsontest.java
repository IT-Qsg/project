package lut.json;

import net.sf.json.JSONArray;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/24 19:11
 * @describe
 **/
public class jsontest {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(10);
        s.setName("lili");
        /*JSONArray js = new JSONArray();
        js.add(1,s.getId());
        js.add(2,s.getName());
        System.out.println(js.toString());*/
        //sfShowUser(s);
        org.json.JSONArray js = new org.json.JSONArray();
        js.put(0,s.getName());
        js.put(1,s.getId());
        System.out.println(js.toString());
    }
    public static void sfShowUser(Student u){
        JSONArray json2=new JSONArray();
        json2.add(1, u.getName());
        System.out.println(json2.toString());

    }
}

class Student{
    int id;
    String name ;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student() {
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

package lut.jdbc.jdbc1;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/22 20:09
 * @describe
 **/
public class Teacher {
    private int id;
    private String name;
    private int age;

    public Teacher(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Teacher() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

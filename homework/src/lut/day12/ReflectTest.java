package lut.day12;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> s = Student.class;
        Class c = String.class;
        Class<String> c2 = String.class;
        System.out.println(c2+"   "+c);
        Student d = new a();
        Class<? extends  Student> c3 =d.getClass();
        String path = "lut.day12.ReflectTest";
        Class<?> cl = Class.forName(path);
        System.out.println(cl);
    }
}
class a extends Student{}
class Student{
    public void show(){
        System.out.println("Student show 方法");
    }
}
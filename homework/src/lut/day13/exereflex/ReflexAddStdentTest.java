package lut.day13.exereflex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflexAddStdentTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String s = "lut.day13.exereflex.Student";
        Class<?> aClass = Class.forName(s);
        Constructor<?>[] con= aClass.getDeclaredConstructors();
        /*for (Constructor<?> constructor : con) {
            System.out.println(constructor);
        }*/
      //  Constructor<?> constructor = aClass.getConstructor();
       // Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class,int.class);
      //  System.out.println(declaredConstructor);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance("张三", 10);
        Object lisi = declaredConstructor.newInstance("lisi", 20);

        Field[] fields = aClass.getFields();
        System.out.println(fields.length);
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(o));
       // field.set(o,"李四");
      //  System.out.println(field.getName()+":"+field.get(o));
        field = aClass.getDeclaredField("age");
        field.setAccessible(true);
      //  field.set(o,20);
        Method method = aClass.getMethod("start");
        Object invoke = method.invoke(null);
        Object invoke1 = method.invoke(null);
       /* Field[] fields1 = aClass.getFields();
        //System.out.println(fields1.length);
        Field[] declaredFields1 = aClass.getDeclaredFields();
        System.out.println(declaredFields1.length);*/
       //  Field list = aClass.getField("list");//得不到list属性
        Field list = aClass.getDeclaredField("list");
        list.setAccessible(true);
        Object o1 = list.get(o);
        List list1 = (List)o1;
        for (Object o2 : list1) {
            System.out.println(o2);
        }
       // System.out.println(o1);
    }
}
class Student {
    private static List<Student> list = new ArrayList<>();
    private String name;
    private int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //  public Student(){}
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("姓名：");
        String s = bufferedReader.readLine();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("年龄：");
        String s1 = bufferedReader1.readLine();
        int ag = Integer.parseInt(s1);
        list.add(new Student(s,ag));


    }

}
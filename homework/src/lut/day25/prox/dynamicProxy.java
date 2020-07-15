package lut.day25.prox;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dynamicProxy {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //JDK自动提供的动态代理
      //  Proxy pro = new Proxy(); InvocationHandler
        Class<StudentManage> sm = StudentManage.class;
        ClassLoader classLoader = sm.getClassLoader();
        Class<?>[] interfaces = sm.getInterfaces();
        StudentManage studentManage = sm.newInstance();
        Manage o =(Manage) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            //返回值低所调用目标方法的返回值
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Logger.log("动态代理了："+method.getName()+"方法！");
                Object invoke = method.invoke(studentManage, args);
                return invoke;
            }
        });
        o.add(new Student("hahaha",20));

    }
    }
interface Manage{
    void add(Student s);
    void delect(Student s);
}
class StudentManage implements Manage{

    @Override
    public void add(Student s) {
        System.out.println("ADD"+s);
    }

    @Override
    public void delect(Student s) {
        System.out.println("DELECT"+s);
    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
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
}

class Logger{
    public  static void log(String info) throws FileNotFoundException {
        PrintWriter log = new PrintWriter(new FileOutputStream("E:\\a.log", true), true);
        Date date = new Date();
       // String s = date.toString();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss S");
        String format = sd.format(date);
        log.println("【"+format+"】："+info);
        log.close();

    }
}
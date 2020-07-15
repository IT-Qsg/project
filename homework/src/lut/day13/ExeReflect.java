package lut.day13;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExeReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "lut.day13.A";
        Class<?> dd = Class.forName(s);
        System.out.println(dd);
        Annotation[] a = dd.getAnnotations();
        System.out.println(a);
        ClassLoader c = dd.getClassLoader();
        System.out.println(c);
        Constructor<?>[] declaredConstructors = dd.getDeclaredConstructors();
        System.out.println(declaredConstructors[0]+"   "+declaredConstructors[1]);
        Package ddPackage = dd.getPackage();
        System.out.println(ddPackage);
        String ddName = dd.getName();
        System.out.println(ddName);
        Method[] ddMethods = dd.getMethods();
        System.out.println(ddMethods[0]+"    "+ddMethods[1]);
        Field[] ddFields = dd.getFields();
        System.out.println(ddFields.length);
        System.out.println(ddFields[0]);
        boolean array = dd.isArray();
        System.out.println(array);

    }
}
class A{
    A(){}
    A(int s){}
    public int i;
    public void s(){}
    public void ddd(int s){}
    /*
    *
    * 类A的注释
    * 测试Class类型
    * */

    //注释二

}
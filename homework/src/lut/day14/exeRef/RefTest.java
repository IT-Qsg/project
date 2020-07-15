package lut.day14.exeRef;

import java.lang.reflect.*;
import java.util.List;

public class RefTest {
    public static void main(String[] args) {
        String url = "lut.day14.exeRef.Person";
        Class<?> per = null;
        try {
            per = Class.forName(url);
            Constructor<?>[] constructors = per.getConstructors();
            Constructor<?> constructor = per.getConstructor(String.class);
            Object o = constructor.newInstance("ren");
            //Field[] fields = per.getFields();
            //System.out.println(fields.length);
            /*for (Field field : fields) {
                System.out.println(field);
            }*/
            Field[] declaredFields = per.getDeclaredFields();
            Field name = per.getDeclaredField("name");
            name.setAccessible(true);
            name.set(o,"lisi");
            System.out.println(name.get(o));

            Method[] declaredMethods = per.getDeclaredMethods();
           /* for (Method method : declaredMethods) {
                System.out.println(method);
            }*/

            Method arr = per.getMethod("arr", int[].class);
            Object o1 = Array.newInstance(int.class, 20);
            for (int i = 0 ;i < Array.getLength(o1);i++){
                Array.set(o1,i,i);
            }
            arr.invoke(o, o1);
            Method b = per.getDeclaredMethod("b");
            b.setAccessible(true);
            b.invoke(o);
            Class<?> superclass = per.getSuperclass();
            System.out.println(superclass);
            Class<?>[] interfaces = per.getInterfaces();
            System.out.println(interfaces.length);



        /*for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }*/
        /*Constructor<?>[] declaredConstructors = per.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
         //   System.out.println(constructor);
        }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
interface  a{}
interface b extends a{}
class Person implements b{
    private String name;
    Person(){}

    public Person(String name) {
        this.name = name;
    }
    private void b(){
        System.out.println("b方法");
    }
    public void arr(int... a){
        for (int i : a) {
            System.out.println(i);
        }

    }
}
class s{
    List<? super  Object> list;
    List<? extends  Object> lis;
    public  void d(List<? extends Object>  l){}
    public void D(List<?  super Object>  list){}
}
interface  f{
    public  abstract  void n();
    public default  void g(){
    }
}
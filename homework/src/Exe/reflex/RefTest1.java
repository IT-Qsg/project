package Exe.reflex;

import java.lang.reflect.*;

public class RefTest1 {
    public static void main(String[] args) {

        String url = "Exe.reflex.Person";

        try {
            Class<?> name1 = Class.forName(url);
           // System.out.println(name1.getSuperclass()+"=========");
            //int modifiers = name1.getModifiers();
            //String s = Modifier.toString(modifiers);
            //System.out.println(modifiers+""+s+"=====");
            for (Constructor<?> declaredConstructor : name1.getConstructors()) {
                System.out.println(declaredConstructor+"构造器");
            }
            //方式一存在无参构造器可直接创建构造器
            Object oo = name1.newInstance();
            //方式二：存在有参数构造器时，根据有参数构造器创建对象
            Object o = name1.getConstructor(int.class, String.class, String.class).newInstance(20, "张三", "兰州");
            //根据对象调用相应镜像中的方法
            //获取方法
            for (Method method : name1.getDeclaredMethods()) {
                System.out.println(method);
            }
            //根据修饰符调用相应方法
            //如果是静态方法，方法invoke(null,……)第一个对象参数可以为空，直接通过类名去调用
            Method go = name1.getMethod("Go");//方式一：分两步，获取方法名,然后调用方法
            go.invoke(o);
            name1.getMethod("Go",String.class).invoke(o,"小明");//方式二，直接调用

            //获取对应类镜像中的成员变量public Field
            for (Field field : name1.getFields()) {
                System.out.println(field+"  公有变量");
            }
            for (Field field : name1.getDeclaredFields()) {
                System.out.println(field +"  本类的所有变量");
            }
            Field age = name1.getDeclaredField("age");
           // age.setAccessible();//不需要暴力访问
            age.setInt(o,20);
            name1.getDeclaredField("name").set(o,"lisi");
            name1.getDeclaredField("addres").set(o,"上海");
            System.out.println(o);

            /*
             * 使用反射，将对象加入List集合中
             * */
            // Class<ArrayList> arrayListClass = ArrayList.class;
            String url2 = "java.util.ArrayList";
            Class<?> name2 = null;
                //根据类全名获取ArrayList集合累得镜像
                name2 = Class.forName(url2);
                //获取所对应镜像方法
                Method add = name2.getMethod("add", Object.class);
                //创建对象，使用方法
                /*1.获取构造器
                 *2.创建对象
                 */
                for (Constructor<?> constructor : name2.getConstructors()) {
                    System.out.println(constructor);
                }
                //方式一：存在公有的无参构造器，直接进行实例化
                Object o2 = name2.newInstance();
                //方式二：根据构造器参数个数进行创建对象
                Constructor<?> constructor = name2.getConstructor(int.class);
                Object o3 = constructor.newInstance(10);
                //根据对象，使用被调方法
                Object invoke = add.invoke(o2, o);
                add.invoke(o2,oo);
            System.out.println(o2);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }



    }
}
class p1{
    public p1(){}
    public String s;
    public void dd(){}
}
class Person extends  p1{
    /**
     * @param
     */
    public final int s = 1;
    protected int age;
    String name;
    String addres;
    Person(){}

    public Person(int age, String name, String addres) {
        this.age = age;
        this.name = name;
        this.addres = addres;
    }
    public void Go(String name){
        System.out.println("小孩"+name+"已经会跑了");
    }

    public  void Go(){
        System.out.println("大人都会走");
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+"@"+Integer.toHexString(this.hashCode())+
                " age=" + age +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' ;
    }
}

package com.lut.spring.firstSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/3/28 16:45
 * @describe
 **/
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext contest = new ClassPathXmlApplicationContext(new String[]{"D:\\ideaIU\\project\\spring\\src\\main\\config\\applicationContext.xml"});

        Source sour = (Source)contest.getBean("source");
        System.out.println(sour.getFruit());
        System.out.println(sour.getSize());
        System.out.println(sour.getSugar());


    }
}
class a{
    static {
        System.out.println("a");
    }
    public a(){
        System.out.println("b");
    }
}
class b extends a{
    static {
        System.out.println("c");
    }
    public b(){
        System.out.println("d");
    }

    public static void main(String[] args) {
        a t = new b();
        t = new b();
    }
}

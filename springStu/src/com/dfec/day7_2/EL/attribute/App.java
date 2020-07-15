package com.dfec.day7_2.EL.attribute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 10:20
 * @describe
 **/
public class App {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/day7_2/EL/attribute/ELatt.xml");
        Customer cus = (Customer)app.getBean("customerBean");
        System.out.println(cus);

    }
}

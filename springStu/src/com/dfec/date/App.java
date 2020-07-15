package com.dfec.date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 14:26
 * @describe
 **/
public class App {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/date/date.xml");
        Customer cus = (Customer)app.getBean("customer");
        System.out.println(cus);
        Date date = cus.getDate();
        System.out.println(date);
    }
}

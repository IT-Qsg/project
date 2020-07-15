package com.dfec.depend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 依赖检查
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/depend/depend.xml");
        Customer cus = (Customer)app.getBean("CustomerBean");
        System.out.println(cus);
    }
}

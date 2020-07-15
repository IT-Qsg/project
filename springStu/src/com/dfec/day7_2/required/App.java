package com.dfec.day7_2.required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 8:00
 * @describe 使用 Required 注解（确保特定属性已经设置）
 **/
public class App {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/day7_2/required/required.xml");
        Customer cus = (Customer)app.getBean("CustomerBean");
        System.out.println(cus);



    }
}

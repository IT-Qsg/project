package com.dfec.day7_2.required.req;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 8:40
 * @describe 自定义required类型
 **/
public class App {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/day7_2/required/req/required.xml");
        Customer cus = (Customer)app.getBean("CustomerBean");
        System.out.println(cus);
    }
}

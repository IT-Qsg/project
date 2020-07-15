package com.dfec.day7_2.init_dis.init;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:35
 * @describe
 **/
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext con = new ClassPathXmlApplicationContext("com/dfec/day7_2/init_dis/init/init.xml");
        CustomerService cus = (CustomerService) con.getBean("customerService");
        System.out.println(cus);
        con.close();

    }
}

package com.dfec.day7_2.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 11:50
 * @describe 自动扫描组件
 **/
public class App {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/day7_2/scan/scan.xml");
        CustomerService cus = (CustomerService) app.getBean("customerService");
        System.out.println(cus);
    }
}

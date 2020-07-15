package com.dfec.day7_2.init_dis;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:08
 * @describe 属性的初始化一销毁
 **/
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext con = new ClassPathXmlApplicationContext("com/dfec/day7_2/init_dis/inin_dis.xml");
        CusromerService cus = (CusromerService) con.getBean("customerService");
        System.out.println(cus);
        con.close();
    }
}

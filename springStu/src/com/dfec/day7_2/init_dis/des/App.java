package com.dfec.day7_2.init_dis.des;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:42
 * @describe 使用注解 @PostConstruct 和 @PreDestroy 进行初始化与销毁
 **/
public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext con = new ClassPathXmlApplicationContext("com/dfec/day7_2/init_dis/des/initdes.xml");
        CustomerService cus = (CustomerService) con.getBean("customerService");
        System.out.println(cus);
        con.close();
    }
}

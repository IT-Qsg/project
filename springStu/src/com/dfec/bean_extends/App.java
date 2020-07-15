package com.dfec.bean_extends;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 16:44
 * @describe
 **/
public class App {
    public static void main(String[] args) {
       ApplicationContext app =  new ClassPathXmlApplicationContext("com/dfec/bean_extends/extend.xml");
        //子类buy覆盖父类的go
       Customer cus = (Customer)app.getBean("CustomerBean");
        System.out.println(cus);
        //父类依然能被实例化（配置文件中不加abstract=true） 输出go
        Customer cusp = (Customer)app.getBean("BaseCustomerMalaysia");
        System.out.println(cusp);

    }
}

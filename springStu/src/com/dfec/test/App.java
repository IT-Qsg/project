package com.dfec.test;

import com.dfec.util.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 13:19
 * @describe
 **/
public class App {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/conf/application.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/conf/applist.xml");
        Customer cus =(Customer) app.getBean("CustomerBean");
        List list = cus.getList();
        list.forEach(e->{
            Log.logger.info(e);
        });



    }

}

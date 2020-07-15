package com.dfec.day7_2.init_dis;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:06
 * @describe
 **/
public class CusromerService implements InitializingBean, DisposableBean {
    private String mas;

    public String getMas() {
        return mas;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("关闭销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}

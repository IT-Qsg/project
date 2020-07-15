package com.dfec.day7_2.init_dis.des;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:49
 * @describe
 **/
public class CustomerService {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    @PostConstruct
    public void init(){
        System.out.println("初始："+msg);
    }
    @PreDestroy
    public void des(){
        System.out.println("销毁："+msg);
    }
}

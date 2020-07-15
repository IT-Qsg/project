package com.dfec.day7_2.init_dis.init;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 9:26
 * @describe 使用init-method和destroy-method 替代接口实现的方式
 **/
public class CustomerService  {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void init(){
        System.out.println("初始化之后");
    }
    public void des(){
        System.out.println("关闭销毁");
    }
}

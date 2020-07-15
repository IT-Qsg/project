package com.dfec.day7_2.required.req;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 7:59
 * @describe Required 注解
 **/
public class Customer {
    private int type;
    private Person person;

    private String action;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }
    @Mandatory
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "type=" + type +
                ", person=" + person +
                ", action='" + action + '\'' +
                '}';
    }
}

package com.dfec.springbootmybatis.entity;

import java.io.Serializable;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 8:56
 * @describe
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1222221L;
    private Integer id;
    private String username;
    private String password;
    private String realname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}

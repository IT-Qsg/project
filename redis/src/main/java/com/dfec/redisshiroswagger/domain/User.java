package com.dfec.redisshiroswagger.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;

import java.util.List;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname User
 * @Date 2020/7/21 10:08
 * @Copyright DFEC
 **/
@Data
@TableName("USER")
public class User {
    //一个用户对应多个角色
    private Long id;
    private String name;
    private Integer password;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}

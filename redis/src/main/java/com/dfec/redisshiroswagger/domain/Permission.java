package com.dfec.redisshiroswagger.domain;

import lombok.Data;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Permission
 * @Date 2020/7/21 10:16
 * @Copyright DFEC
 **/
@Data
public class Permission {
    private Long id;
    private  String permission;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

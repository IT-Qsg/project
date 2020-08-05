package com.dfec.redisshiroswagger.domain;

import lombok.Data;

import java.util.List;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Role
 * @Date 2020/7/21 10:16
 * @Copyright DFEC
 **/
@Data
public class Role {
    private Long id;
    private String roleName;
    private User user;
    private List<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}

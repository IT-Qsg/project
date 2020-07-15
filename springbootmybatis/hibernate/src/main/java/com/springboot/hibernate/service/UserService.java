package com.springboot.hibernate.service;

import com.springboot.hibernate.entity.User;
import com.springboot.hibernate.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/15 10:23
 * @describe
 **/
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepositoty.findByUserName(name);
        } catch (Exception e) {
        }
        return user;
    }
}

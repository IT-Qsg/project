package com.dfec.springbootmybatis.service;

import com.dfec.springbootmybatis.entity.User;
import com.dfec.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 8:59
 * @describe
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(int id){
        return userMapper.findById(id);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }
    public void updataUser(User user){
        userMapper.updataUser(user);
    }
    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }
}

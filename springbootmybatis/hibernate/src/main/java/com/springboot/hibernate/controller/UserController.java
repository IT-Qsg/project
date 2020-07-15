package com.springboot.hibernate.controller;

import com.springboot.hibernate.entity.User;
import com.springboot.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/15 10:21
 * @describe
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }
    @RequestMapping("/show")
    public User finduser(@RequestParam(value = "name") String name){
        User user = userService.findUserByName(name);
        return user;
    }
}

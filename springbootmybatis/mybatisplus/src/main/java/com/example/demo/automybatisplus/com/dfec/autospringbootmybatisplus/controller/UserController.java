package com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.entity.User;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.mapper.UserMapper;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qsg
 * @since 2020-07-14
 */
@Controller
@RequestMapping("//user")
public class UserController {
    @Autowired
    private IUserService userSvc;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/show/{page}")
    public JSONObject testEnum(@PathVariable("page") String page) {
       // Page<User> users = userSvc.selectPage(new Page<User>(Integer.parseInt(page), 20));
        Page<User> users = userSvc.page( new Page<User>(Integer.parseInt(page), 20));
        User user = new User();
        user.setAge(1);
        user.setName("1tewq");
        user.setEmail("tyty@998.com");
        userSvc.save(user);
        List<OrderItem> orders = users.getOrders();
        System.out.println("大小"+orders.size());
       /* orders.forEach(o -> {
            System.out.println(o.toString());
            System.out.println(o.getColumn());
            System.out.println("*******************");
        });*/
        List<User> records = users.getRecords();
        records.forEach(System.out::println);
        JSONObject result = new JSONObject();
        result.put("users", users);

        return result;
    }
    @GetMapping(value = "/users")
    public List<User> findAll(){
        List<User> users = userMapper.selectList(new QueryWrapper<User>().between("id", 0, 100));
        System.out.println(users);
        return users;
    }
    @GetMapping(value = "/user")
    public void selectUser(){
        HashMap<String, Object> map = new HashMap<>();
       // map.put("id", 3l);
        map.put("name","Jone");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users.size());
        users.forEach(System.out::println);

    }



}

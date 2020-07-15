package com.dfec.springbootmybatis.controller;

import com.dfec.springbootmybatis.entity.User;
import com.dfec.springbootmybatis.exception.UserNotFoundException;
import com.dfec.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 8:58
 * @describe
 **/
@RestController
@RequestMapping("/boot")
public class UserController {

    private static Map<Integer, User> userMap = new HashMap<>();
    static {
        User user = new User();
        user.setId(1);
        user.setUsername("Honey");
        user.setPassword("123");
        user.setRealname("ranme1");
        userMap.put(user.getId(), user);

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("Almond");
        user2.setPassword("1232");
        user2.setRealname("ranme2");
        userMap.put(user2.getId(), user2);
    }
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
    public String findById(@PathVariable int id){
        return userService.findById(id).toString();
    }
    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "添加成功！！";
    }
    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }
    @RequestMapping("/updateUser")
    public String updataUser(User user){
        userService.updataUser(user);
        return "跟新成功";
    }
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        userService.deleteById(id);
        return "删除成功";
    }
   // id=3&username=二七塔&password=456&realname=wang
   // id=4&username=容器塔&password=456&realname=wang

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id) {
        if(!userMap.containsKey(id))throw new UserNotFoundException();
        userMap.remove(id);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Object> updateUser() {
        return new ResponseEntity<>(userMap.values(), HttpStatus.OK);
    }
    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public ResponseEntity<Object> updateUser2(@RequestBody Map<String, String> params) {
        params.forEach((key,value)->{
            System.out.println(key);
        });
       /* System.out.println(params.);*/
        return new ResponseEntity<>(userMap.values(), HttpStatus.OK);
    }
}

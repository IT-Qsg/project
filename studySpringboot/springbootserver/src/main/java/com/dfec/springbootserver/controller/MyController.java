package com.dfec.springbootserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MyController
 * @Date 2020/7/16 11:48
 * @Copyright DFEC
 **/
@Controller
//@RequestMapping("/springboot")
public class MyController {

    @RequestMapping(value ="/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value ="/loginpage",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value ="/login",method = RequestMethod.GET)
    public  String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password){
     model.addAttribute("username",username);
        model.addAttribute("password",password);
        System.out.println(username);
        return "message";
    }
}

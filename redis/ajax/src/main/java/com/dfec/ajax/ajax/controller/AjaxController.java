package com.dfec.ajax.ajax.controller;

import com.dfec.ajax.ajax.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname AjaxController
 * @Date 2020/7/20 9:49
 * @Copyright DFEC
 **/
@Controller
public class AjaxController {

    @RequestMapping(value = "/hello")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "test1",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> ajaxTest1(@RequestParam("id") String id, @RequestParam("name") String name){
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        System.out.println(id);
        return map;
    }

    //用 RequestBody只能是POST方法 post提交的数据在body区
    @RequestMapping(value = "/testpost",method = RequestMethod.POST)
    @ResponseBody
    public Map ajaxTestPost(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        System.out.println(user.getId());
        return map;
    }
    @RequestMapping(value = "/testget",method = RequestMethod.GET)
    @ResponseBody
    public Map ajaxTestPosGet(@RequestParam("id") String id, @RequestParam("name") String name){
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        System.out.println(id);
        return map;
       /* HashMap<String, String> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        System.out.println(user.getId());
        return map;*/
    }

}

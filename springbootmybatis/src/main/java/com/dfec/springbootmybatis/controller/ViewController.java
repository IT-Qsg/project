package com.dfec.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/9 15:07
 * @describe
 **/
@Controller
public class ViewController {
    @RequestMapping("/view-products")
    public String viewProducts() {
        return "view-products";
    }
    @RequestMapping("/add-products")
    public String addProducts() {
        return "add-products";
    }
}

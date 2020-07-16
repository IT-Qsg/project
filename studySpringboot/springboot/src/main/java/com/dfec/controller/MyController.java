package com.dfec.controller;

import com.dfec.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MyController
 * @Date 2020/7/16 10:36
 * @Copyright DFEC
 **/
@RestController
public class MyController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private R getMessage(){
        return R.ok();
    }
}

package com.dfec.springbootmybatis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/9 14:13
 * @describe
 **/
@Component
public class UserServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private UserServiceInterceptor userServiceInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userServiceInterceptor);
    }
}

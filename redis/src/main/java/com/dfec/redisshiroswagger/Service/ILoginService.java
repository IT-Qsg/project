package com.dfec.redisshiroswagger.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dfec.redisshiroswagger.domain.User;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname ILoginService
 * @Date 2020/7/21 10:24
 * @Copyright DFEC
 **/
public interface ILoginService extends IService<User> {
    public User findByName(String name);
}

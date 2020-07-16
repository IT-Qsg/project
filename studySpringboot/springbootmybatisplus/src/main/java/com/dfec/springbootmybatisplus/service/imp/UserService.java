package com.dfec.springbootmybatisplus.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfec.springbootmybatisplus.entity.User;
import com.dfec.springbootmybatisplus.mapper.UserMapper;
import com.dfec.springbootmybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname UserService
 * @Date 2020/7/16 15:06
 * @Copyright DFEC
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}

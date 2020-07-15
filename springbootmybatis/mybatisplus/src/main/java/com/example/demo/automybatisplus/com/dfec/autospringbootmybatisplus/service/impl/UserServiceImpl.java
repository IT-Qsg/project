package com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.entity.User;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.mapper.UserMapper;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qsg
 * @since 2020-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

   @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> selectPage(Page<User> objectPage) {
        return userMapper.selectPage(objectPage,new QueryWrapper<User>().ge("id",5l));
    }
}

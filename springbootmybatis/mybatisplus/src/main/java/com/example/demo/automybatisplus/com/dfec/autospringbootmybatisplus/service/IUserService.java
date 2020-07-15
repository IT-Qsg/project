package com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.automybatisplus.com.dfec.autospringbootmybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qsg
 * @since 2020-07-14
 */
public interface IUserService extends IService<User> {

     Page<User> selectPage(Page<User> objectPage);
}

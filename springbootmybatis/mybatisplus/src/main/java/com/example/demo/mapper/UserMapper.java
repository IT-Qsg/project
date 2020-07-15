package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/13 16:46
 * @describe
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
}

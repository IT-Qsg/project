package com.dfec.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dfec.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname UserMapper
 * @Date 2020/7/16 15:05
 * @Copyright DFEC
 **/
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}

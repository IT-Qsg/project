package com.dfec.redisshiroswagger.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname BaseRepo
 * @Date 2020/7/21 11:17
 * @Copyright DFEC
 **/
@Mapper
@Repository
public interface BaseRepo<T> extends BaseMapper<T> {
}

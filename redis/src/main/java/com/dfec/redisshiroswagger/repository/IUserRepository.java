package com.dfec.redisshiroswagger.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname IUserRepository
 * @Date 2020/7/21 11:16
 * @Copyright DFEC
 **/
@Mapper
@Repository
public interface IUserRepository<User> extends BaseRepo<User>{
}

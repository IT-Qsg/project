package com.dfec.redisshiroswagger.repository;

import com.dfec.redisshiroswagger.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname IRoleRepository
 * @Date 2020/7/21 11:17
 * @Copyright DFEC
 **/
@Mapper
@Repository
public interface IRoleRepository<Role> extends BaseRepo<Role>{
}

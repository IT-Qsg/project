package com.dfec.springbootmybatis.mapper;

import com.dfec.springbootmybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 8:59
 * @describe
 **/
@Repository
public interface UserMapper {
    User findById(int id);
    void addUser(User user);
    List<User> findAllUser();
    void updataUser(User user);
    void deleteById(Integer id);

}

package com.springboot.hibernate.repository;

import com.springboot.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/15 10:25
 * @describe
 **/
@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {
    @Query("SELECT u FROM user u where u.name=:name")
    public User findByUserName(@Param("name") String name);
}

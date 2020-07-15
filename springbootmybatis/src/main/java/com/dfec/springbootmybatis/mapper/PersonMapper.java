package com.dfec.springbootmybatis.mapper;

import com.dfec.springbootmybatis.entity.Person;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 11:14
 * @describe
 **/
@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(Long id);

    long insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    /**
     * 获取所有数据
     * @return
     */
    List<Person> findAll();

    /**
     * 分页查询数据
     * @return
     */
    Page<Person> findByPage();

}

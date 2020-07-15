package com.dfec.springbootmybatis.service;

import com.dfec.springbootmybatis.entity.Person;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 11:22
 * @describe
 **/
@Service
public interface PersonService {
    List<Person> findAll();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<Person> findByPage(int pageNo, int pageSize);

    long insert(Person person);
}

package com.dfec.springbootmybatis.service;

import com.dfec.springbootmybatis.entity.Person;
import com.dfec.springbootmybatis.mapper.PersonMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 11:25
 * @describe
 **/

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Override
    public List<Person> findAll() {
        System.out.println(personMapper.findAll());
        return personMapper.findAll();
    }

    @Override
    public Page<Person> findByPage(int pageNo, int pageSize) {
        //先对查询结果进行设置
        PageHelper.startPage(pageNo,pageSize);
        return personMapper.findByPage();
    }

    @Override
    @Transactional
    public long insert(Person person) {
        System.out.println(person.getAddress());
        System.out.println(person.getId());
        return personMapper.insert(person);
    }
}

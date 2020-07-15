package com.example.demo.entity;

import lombok.Data;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/13 16:44
 * @describe
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

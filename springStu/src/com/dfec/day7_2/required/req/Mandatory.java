package com.dfec.day7_2.required.req;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 8:44
 * @describe 自定义required style
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Mandatory {
}

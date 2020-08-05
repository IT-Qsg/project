package com.dfec.redisshiroswagger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /*
    *
    * redis 进行增删该查
    *
    * */
    @Test
    public void test(){
        redisTemplate.opsForValue().set("fff","tttt");
        Object fff = redisTemplate.opsForValue().get("fff");
        System.out.println(fff);
        redisTemplate.opsForValue().set("123","2580",12, TimeUnit.SECONDS);

       List<String> l = new ArrayList<String>();
       l.add("字符串添加");
       l.add("test String");

        redisTemplate.opsForList().leftPush("list",l);
        redisTemplate.opsForList().leftPush("list",23);
        redisTemplate.opsForList().leftPush("list",55);

        Object list = redisTemplate.opsForList().index("list", 0);

        System.out.println(list);

        Object list1 = redisTemplate.opsForList().leftPop("list");


        List list2 = redisTemplate.opsForList().range("list", 0, 2);
        System.out.println(list2.size());

        for (Object o : list2) {
            System.out.println(o);
        }

    }



}

package com.dfec.redisshiroswagger;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisShiroSwaggerApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    /*
    * redis 操作
    * */

    /*
    * 添加数据
    * */
    @Test
    public void redisADD(){
        redisTemplate.opsForValue().set("rediskey","redisvalue");
        String value = (String)redisTemplate.opsForValue().get("rediskey");
        System.out.println(value);
    }

}

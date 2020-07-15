package com.dfec.springbootmybatis.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 10:12
 * @describe
 **/
@Service
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private String id;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public RedisCache() {}

    public RedisCache(final String id) {
        if(id == null) throw new IllegalArgumentException("Cache instances require an ID");
        logger.info("Redis 缓存 ID ：" +id);
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }
    //将数据存入redis 有效时间 2 天
    @Override
    public void putObject(Object key, Object value) {
        if(value!=null)redisTemplate.opsForValue().set(key.toString(),value,2, TimeUnit.DAYS);
    }
    @Override
    public Object getObject(Object o) {
        if(o != null) return redisTemplate.opsForValue().get(o.toString());
        logger.error("redis key 为空");
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        if(o != null) return redisTemplate.delete(o.toString());
        return null;
    }

    @Override
    public void clear() {
        logger.debug("清空缓存！");
        Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
        if(CollectionUtils.isEmpty(keys))redisTemplate.delete(keys);
    }

    @Override
    public int getSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        }).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}

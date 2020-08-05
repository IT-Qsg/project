package com.dfec.flink.redis;

import org.apache.flink.streaming.connectors.redis.RedisSink;
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SinkRedisUtil
 * @Date 2020/7/29 16:49
 * @Copyright DFEC
 **/
public class SinkRedisUtil {
    public static RedisSink<Person> getRedisSink(){

        FlinkJedisPoolConfig fb = new FlinkJedisPoolConfig.Builder()
                .setDatabase(1)
                .setHost("127.0.0.1")
                .setPort(6379).build();
        return  new RedisSink<Person>(fb,new SinkRedisMapper());
    }
}
class SinkRedisMapper implements RedisMapper<Person> {

        @Override
        public RedisCommandDescription getCommandDescription() {
                //string 类型
                return new RedisCommandDescription(RedisCommand.LPUSH,null);
                }

        @Override
        public String getKeyFromData(Person person) {
//                return person.getId()+"";
            return "person";
                }

        @Override
        public String getValueFromData(Person person) {
                return person.toString();
                }

}
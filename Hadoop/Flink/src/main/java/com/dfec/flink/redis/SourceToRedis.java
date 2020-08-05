package com.dfec.flink.redis;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSink;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SourceToRedis
 * @Date 2020/7/29 17:37
 * @Copyright DFEC
 **/
public class SourceToRedis {
    public static void main(String[] args) throws Exception {
       /* ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> ds = env.readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\redis\\person");
        MapOperator<String, Person> map = ds.map(s -> {
            String[] sp = s.split(",");
            Person person = new Person();
            person.setId(Integer.parseInt(sp[0]));
            person.setName(sp[1]);
            return person;
        });
        map.writeAsText("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\redis\\daea").setParallelism(1);
        map.print()*/;

        //数据来源mysql
        //构建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Person> ds = env.addSource(new SourceMysql());
        //数据存入redis
        ds.addSink(SinkRedisUtil.getRedisSink());
        ds.print();
        env.execute();


    }
}

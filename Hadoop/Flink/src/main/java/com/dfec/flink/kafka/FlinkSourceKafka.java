package com.dfec.flink.kafka;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.util.Collector;

import java.util.Properties;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname FlinkSourceKafka
 * @Date 2020/7/29 8:30
 * @Copyright DFEC
 **/
public class FlinkSourceKafka {
    public static void main(String[] args) throws Exception {
        //构建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //设置执行并行度
        env.setParallelism(2);
        env.enableCheckpointing(5000);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        Properties pro = new Properties();
        pro.setProperty("bootstrap.servers", "192.168.1.171:9092");
        pro.setProperty("group.id", "flink");
        //构建环境
        FlinkKafkaConsumer010<String> kfc = new FlinkKafkaConsumer010<>("estest", new SimpleStringSchema(), pro);
        SingleOutputStreamOperator<Tuple2<String, Integer>> v = env.addSource(kfc).flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                System.out.println(value);
                Tuple2<String, Integer> t = new Tuple2<>();
                t.f0 = value;
                t.f1 = 1;
                out.collect(t);
            }
        });
        v.print();
        env.execute();

    }
}
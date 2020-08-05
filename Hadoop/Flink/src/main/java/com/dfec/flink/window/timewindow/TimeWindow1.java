package com.dfec.flink.window.timewindow;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname TimeWindow1
 * @Date 2020/7/30 11:19
 * @Copyright DFEC
 **/
public class TimeWindow1 {
    public static void main(String[] args) throws Exception {
        //构建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> ds = env.socketTextStream("192.168.1.174", 7777);
        ds.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] s1 = s.split(" ");
                Tuple2<String, Integer> t2 = new Tuple2<>();
                t2.f0=s1[0];
                t2.f1=Integer.parseInt(s1[1]);
                collector.collect(t2);
            }
        }).map(new MapFunction<Tuple2<String, Integer>, Integer>() {
            @Override
            public Integer map(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                return stringIntegerTuple2.f1;
            }
        }).print();
        env.execute();

       /* DataStreamSource<String> ds = env.setParallelism(1).readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\window\\timewindow\\time");

        SingleOutputStreamOperator<Tuple3<String, Integer, String>> map = ds.map(s -> {
            String[] s1 = s.split(" ");
            Tuple3<String, Integer, String> tup = new Tuple3<>(s1[0], (Integer.parseInt(s1[1])), s1[2]);
            return tup;
        });
      //  AllWindowedStream<Tuple3<String, Integer, String>, TimeWindow> t = map.timeWindowAll(Time.seconds(2));
        map.print();
*//*
        KeyedStream<Tuple3<String, Integer, String>, Tuple> kb =  map.keyBy(1);
        WindowedStream<Tuple3<String, Integer, String>, Tuple, TimeWindow> t = kb.timeWindow(Time.seconds(2));
        SingleOutputStreamOperator<Tuple3<String, Integer, String>> so = t.max(2);
        so.writeAsText("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\window\\timewindow\\time");

        so.print();*//*
        env.execute();*/
    }
}

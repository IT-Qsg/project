package com.dfec.flink.mysql;


import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname FlinkSourceMysql
 * @Date 2020/7/29 14:16
 * @Copyright DFEC
 **/
public class FlinkSourceMysql {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Student> source = env.addSource(new FlinkSourceUtil());
        SingleOutputStreamOperator<Student> stu = source.flatMap(new FlatMapFunction<Student, Student>() {
            @Override
            public void flatMap(Student student, Collector<Student> stu) throws Exception {
                System.out.println("--------"+student);
                stu.collect(student);
            }
        });

        System.out.println("********************8");

        SingleOutputStreamOperator<String> map = stu.map(new MapFunction<Student, String>() {
            @Override
            public String map(Student student) throws Exception {
                return "Student id = " + student.getId();
            }
        });

        SingleOutputStreamOperator<Student> filter = source.filter(new FilterFunction<Student>() {
            @Override
            public boolean filter(Student student) throws Exception {
                return student.getId() % 2 == 0;
            }
        });
       /* filter.print();

         map.print();*/
        stu.addSink(new MysqlSinkUtil());

        stu.print();
        env.execute("flink 对接 mysql");
    }

}

package com.dfec.flink.table.Table_java;

import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.StreamTableEnvironment;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname StreamTableTest
 * @Date 2020/7/31 15:44
 * @Copyright DFEC
 **/
public class StreamTableTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
//        TextInputFormat tinf = new TextInputFormat(new Path("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\Table_java\\aTable"));
//        tinf.setCharsetName("utf-8");
//        see.readFile(tinf,"D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\Table_java\\aTable");
        DataStreamSource<String> dss = see.readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\Table_java\\aTable");
        SingleOutputStreamOperator<a> map = dss.map(s -> {
            String[] s1 = s.split(" ");
            //   System.out.println(s1[0]);
            return new a(s1[0], Integer.parseInt(s1[1]));
        });

        StreamTableEnvironment ste = StreamTableEnvironment.getTableEnvironment(see);
        ste.registerDataStream("strtable",map,"name,id");
        ste.fromDataStream(map);
        Table table = ste.sqlQuery("select name,id from strtable where id=2");

        ste.toAppendStream(table,a.class).print();

        see.execute();

    }
}

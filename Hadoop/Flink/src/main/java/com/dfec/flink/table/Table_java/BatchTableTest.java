package com.dfec.flink.table.Table_java;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.BatchTableEnvironment;


/**
 * @author qsg
 * @version 1.0 v
 * @Classname BatchTableTest
 * @Date 2020/7/31 14:58
 * @Copyright DFEC
 **/
public class BatchTableTest {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //批处理
        BatchTableEnvironment bte = BatchTableEnvironment.getTableEnvironment(env);
        DataSource<String> ds = env.readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\Table_java\\aTable");
        MapOperator<String, a> map = ds.map(s -> {
            String[] s1 = s.split(" ");
         //   System.out.println(s1[0]);
            return new a(s1[0], Integer.parseInt(s1[1]));
        });
        bte.registerDataSet("tt",map,"name,id");
        Table table = bte.sqlQuery("select name,id from tt");

        DataSet<a> aDataSet = bte.toDataSet(table, a.class);
        aDataSet.print();

    }
}


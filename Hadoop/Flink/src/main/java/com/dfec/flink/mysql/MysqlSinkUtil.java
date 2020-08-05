package com.dfec.flink.mysql;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MysqlSinkUtil
 * @Date 2020/7/29 15:17
 * @Copyright DFEC
 **/
//数据发送到 mysql
public class MysqlSinkUtil extends RichSinkFunction<Student> {
    private Connection connection;

    private  Connection  getConnection(){
        Connection  conn = null;
        try {
//            DruidDataSourceFactory.createDataSource();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flink","root","666888");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        System.out.println("sink open function");
        connection = getConnection();
    }

    @Override
    public void close() throws Exception {
        System.out.println("sink close function");
        super.close();
        if(connection!=null) connection.close();
    }

    //invoke方法会重复调用
    @Override
    public void invoke(Student value, Context context) throws Exception {
        System.out.println("sink invoke function");
        System.out.println("sink value : "+value);
        String sql = "insert into student (name,password,age)value (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,value.getName()+"sink");
        ps.setString(2,value.getPassword()+"sink");
        ps.setString(3,value.getAge()+"sink");
        ps.executeUpdate();
        ps.close();

    }
}

package com.dfec.flink.mysql;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

import java.sql.*;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname FlinkSourceMysql
 * @Date 2020/7/29 14:16
 * @Copyright DFEC
 **/
public class FlinkSourceUtil extends RichSourceFunction<Student> {
    private Connection connection;
    private PreparedStatement preparedStatement;

    private Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flink","root","666888");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    @Override
    public void close() throws Exception {
        System.out.println("close function");
        super.close();
        if(preparedStatement!=null) {
            preparedStatement.close();
        }
        if(this.connection!=null){
            connection.close();
        }
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        System.out.println("open function");
        super.open(parameters);
        String sql="select * from student";
        connection = getConnection();
        this.preparedStatement = connection.prepareStatement(sql);

    }

    @Override
    public void run(SourceContext sourceContext) throws Exception {
        System.out.println("run function");
        ResultSet rs = this.preparedStatement.executeQuery();

        while(rs.next()){
            sourceContext.collect(new Student(
                    rs.getInt("id")
                    ,rs.getString("name")
                    ,rs.getString("password")
                    ,rs.getString("age")));
        }
        rs.close();

    }

    @Override
    public void cancel() {
        System.out.println("cancel function");
    }
}

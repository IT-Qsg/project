package com.dfec.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/1 14:45
 * @describe
 **/
public class CustomerDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public static void main(String[] args) throws SQLException {
       /* DataSource ds = new CustomerDao().getDataSource();
        Connection connection = ds.getConnection();
        System.out.println(connection);*/
        ApplicationContext app = new ClassPathXmlApplicationContext("com/dfec/dao/dao.xml");
        CustomerDao cus = (CustomerDao)app.getBean("dao");
        DataSource dataSource = cus.getDataSource();
        Connection con = dataSource.getConnection();
        System.out.println(con);


    }
}

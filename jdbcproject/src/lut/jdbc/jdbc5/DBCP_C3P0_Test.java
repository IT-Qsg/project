package lut.jdbc.jdbc5;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/25 9:17
 * @describe 数据源
 **/
public class DBCP_C3P0_Test {
    public static void main(String[] args) {
        new DBCP_C3P0_Test().c3p0_conn();
    }
    public void c3p0_conn(){
        ComboPooledDataSource co = new ComboPooledDataSource();
        co.setJdbcUrl("jdbc:mysql://localhost:3306/exejdbc");
        co.setUser("root");
        co.setPassword("666888");
        try {
            Connection conn = co.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void c3p0_filecon(){
        ComboPooledDataSource cpd = new ComboPooledDataSource("mysql");
        try {
            Connection conn = cpd.getConnection();
            System.out.println(conn);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void file_Conn(){
        Properties pro = new Properties();
        try {
            pro.load(new FileReader(new File("src\\lut\\jdbc\\config\\dbcp.properties")));
            BasicDataSource bds = BasicDataSourceFactory.createDataSource(pro);
            Connection conn = bds.getConnection();
            System.out.println(conn);
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 使用代码硬链接的方式
    * */
        public void dbcptest1(){
            BasicDataSource bds = new BasicDataSource();
//        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
//        bds.setUrl(url);
            bds.setUrl("jdbc:mysql://127.0.0.1:3306/exejdbc");
            bds.setUsername("root");
            bds.setPassword("666888");
            bds.setMaxIdle(5);
            bds.setMaxTotal(10);
            bds.setMaxWaitMillis(10000);
            bds.setDefaultAutoCommit(false);
            bds.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            try {
                Connection conn = bds.getConnection();
                System.out.println(conn);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

package com.dfec.impala;

import java.sql.*;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Conn2
 * @Date 2020/7/27 14:59
 * @Copyright DFEC
 **/
public class Conn2 {
    //连接默认库 default
   private final static String connectionUrl = "jdbc:impala://192.168.1.171:21050/ods";
    //使用4.1版本
    private final static String jdbcDriverName = "com.cloudera.impala.jdbc41.Driver";
    //简单的一个查询语句
    private final static String sqlStatement = "show tables;";

    private  static Connection conn = null;
    public static void main(String[] args) {
        try {
            Class.forName(jdbcDriverName);
            conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
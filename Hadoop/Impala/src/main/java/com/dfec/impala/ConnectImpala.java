package com.dfec.impala;

import java.sql.*;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname ConnectImpala
 * @Date 2020/7/24 17:31
 * @Copyright DFEC
 **/
public class ConnectImpala {
    /*
    使用hive 库进行连接impala
     */
        // here is an example query based on one of the Hue Beeswax sample tables
        private static final String SQL_STATEMENT = "SELECT * FROM surf_hor_partition";
        private static final String IMPALAD_HOST = "192.168.1.172";
        private static final String IMPALAD_JDBC_PORT = "21050";
        private static final String CONNECTION_URL = "jdbc:hive2://" + IMPALAD_HOST + ':' + IMPALAD_JDBC_PORT + "/ods;auth=noSasl";
        private static final String JDBC_DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";
        public static void main(String[] args) {

         System.out.println("\n=============================================");
         System.out.println("Cloudera Impala JDBC Example");
         System.out.println("Using Connection URL: " + CONNECTION_URL);
         System.out.println("Running Query: " + SQL_STATEMENT);

         Connection con = null;

         try {

                 Class.forName(JDBC_DRIVER_NAME);
                 con = DriverManager.getConnection(CONNECTION_URL);
                 System.out.println("conn = "+con);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_STATEMENT);
                while (rs.next()) {
                    // the example query returns one String column  
                    System.out.print("name : "+rs.getString("name")+"-");
                    System.out.print("age :"+rs.getInt("age")+"-");
                    System.out.println("id:"+rs.getString("id"));
                }
            System.out.println("== End Query Results =======================\n\n");
        } catch (SQLException e) {
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (Exception e) {  
                // swallow  
            }  
        }  
    }
        public static void insert(Statement stmt) {
        String sql = " INSERT INTO tab001(id, name, age) VALUES (200, '测试', 12) "  ;
        try {
                stmt.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

     }

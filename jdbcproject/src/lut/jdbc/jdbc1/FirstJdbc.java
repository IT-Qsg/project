package lut.jdbc.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/20 14:37
 * @describe
 **/
public class FirstJdbc {
    public void jdbc_test(){
        Connection connection= null;
        try {
          //  Driver driver = new Driver();registerDriver(n
            // DriverManager.ew Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            //给虚拟机传参数
            //System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
            //运行时给虚拟机传参数 run->config  -Djdbc.drivers=com.mysql.jdbc.Driver
            //获取连接
           /* String url ="jdbc:mysql://localhost:3306/briup";
            String user = "root";
            String pwd = "666888";
            Connection connection = DriverManager.getConnection(url, user, pwd);*/

          /*  String url ="jdbc:mysql://localhost:3306/briup";
            Properties pro = new Properties();
            pro.setProperty("user","root");
            pro.setProperty("password","666888");
            Connection connection = DriverManager.getConnection(url, pro);*/

            String url = "jdbc:mysql://localhost:3306/briup?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";

             /*connection = DriverManager.getConnection("jdbc:mysql://192.168.111.129:3306/qsgjdbc?" +
                    "user=qsg_jdbc&password=qsg_jdbc&userUnicode=true&characterEncoding=UTF8");*/
            connection = DriverManager.getConnection(url);
            System.out.println("连接"+connection);
            System.out.println("jshfjks");
            //创建statement对象
            /*Statement sts = connection.createStatement();
            String sql = "create table testcon(" +
                    "id int primary key ," +
                    "name varchar(20))";

            //只有查询语句才有返回结果->true 其它都是 false
            sts.execute(sql);
            if(sts!=null)sts.close();*/



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new FirstJdbc().jdbc_test();
    }
}

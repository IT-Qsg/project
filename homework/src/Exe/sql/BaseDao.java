package Exe.sql;

import java.sql.*;

public class BaseDao {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        String s = "com.mysql.jdbc.Driver";
        Class<?> aClass = Class.forName(s);
        Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","666888");
        System.out.println("连接成功");
       /* String sql = "INSERT INTO USER (NAME) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"张三");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        String sql2 = "SELECT NAME FROM USER";
        PreparedStatement ps = connection.prepareStatement(sql2);
        ResultSet resultSet = ps.executeQuery();
       while(resultSet.next())
           System.out.println(resultSet.getString("name"));*/

       //数据库添加日期
        //获取当前日期
        Date data = new Date(System.currentTimeMillis());
        System.out.println(data);
        //将data对象插入到数据库中
        String sql3 = "INSERT INTO USER (DATE) VALUES (?) WHERE (NAME=?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        preparedStatement.setDate(1,data);
        preparedStatement.setString(2,"张三");
        preparedStatement.executeUpdate();

    }
}

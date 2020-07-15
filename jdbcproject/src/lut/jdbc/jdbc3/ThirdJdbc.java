package lut.jdbc.jdbc3;


import com.mysql.jdbc.Driver;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThirdJdbc {
    private String driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String passwd="root";
    private String url="jdbc:mysql://192.168.43.240:3306/briup";
    public static void main(String[] args) {
        new ThirdJdbc().result_test1();
    }


    public void result_test1(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,passwd);
            String sql="select id,name,age from teacher";
            ps=conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int age=rs.getInt(3);
                System.out.println(id+"-"+name+"-"+age);
                if(name.equals("lisi")){
                    rs.updateString(2,"tom");
                    rs.updateRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

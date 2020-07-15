package lut.jdbc.jdbc3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class tran_test {
    private String driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String passwd="root";
    private String url="jdbc:mysql://192.168.43.240:3306/briup";

    public static void main(String[] args) {
        new tran_test().blob_img_ps();
    }
    public void blob_img_ps(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,passwd);
            conn.setAutoCommit(false);
            String sql="insert into teacher values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2,"lisi");
            ps.setInt(3,30);
            ps.execute();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

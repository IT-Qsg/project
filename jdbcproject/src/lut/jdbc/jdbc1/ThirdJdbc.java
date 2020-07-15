package lut.jdbc.jdbc1;

import java.sql.*;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/23 14:31
 * @describe
 **/
public class ThirdJdbc {
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String passwd = "666888";
    private String url = "jdbc:mysql://localhost:3306/briup";

    public void result_test() throws ClassNotFoundException, SQLException {
        //Class.forName(driver);
        Connection conn = null;
        PreparedStatement par = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url,user,passwd);
            /*String sql = "insert into text_test " +
                    "values (?,?)";
            par = conn.prepareStatement(sql);
            par.setInt(1,1);
            par.setString(2,"lisi");
            par.executeUpdate();*/
            String sql = "";
            par = conn.prepareStatement(sql);
            rs = par.executeQuery();
            while (rs.next()){
                //……
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(par!=null)par.close();
            if(conn!=null)conn.close();
        }
    }
    public static void main(String[] args) {
        try {
            new ThirdJdbc().result_test();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

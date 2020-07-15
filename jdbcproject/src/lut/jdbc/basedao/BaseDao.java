package lut.jdbc.basedao;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/23 18:47
 * @describe
 **/
public class BaseDao {
    private Connection conn = null;
    private PreparedStatement ps=null;
    ResultSet rs = null;
    public Connection getConnection(){
        if(this.conn==null){
        try {
           // DriverManager.registerDriver(new Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
        }else{
            return this.conn;
        }

    }
    public void closeConnection(){
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        if(this.ps!=null) {
            try {
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return  this.ps = this.conn.prepareStatement(sql);
    }
    public ResultSet getResultSet() throws SQLException {
        if(this.rs!=null) {
            try {
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.rs = this.ps.executeQuery();
    }
    public void close() {
        if(this.rs!=null) {
            try {
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.ps!=null) {
            try {
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //开启事物
    public void beginTransation(){
        if(this.conn!=null){
            try {
                //默认情况下是true
                this.conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //提交事物
    public void commit(){
        if(this.conn!=null){
            try {
                this.conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //回滚
    public void rollBack(){
        if(this.conn!=null) {
            try {
                this.conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        new BaseDao().getConnection().close();
    }
}

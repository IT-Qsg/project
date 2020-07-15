package lut.jdbc.jdbc4;

import lut.jdbc.basedao.BaseDao;
import lut.jdbc.jdbc1.Teacher;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/23 19:33
 * @describe 时间与批处理
 **/
public class Date_Batch extends BaseDao {

    public void date_str() {
        //将当前系统时间按照指定格式转换成转换成字符串
        SimpleDateFormat si = new SimpleDateFormat();
        String str = "yyyy-MM-dd HH:mm:ss";
        si.applyPattern(str);
        String format = si.format(new Date());
        System.out.println(format);
        //将指定字符串转换成date类型
        String s= "2019-09-23 12:55:12";
        Date parse = null;
        try {
            parse = si.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        Timestamp ts = new Timestamp(new Date().getTime());
        System.out.println(ts);
        long l=1L;
        Date d= new Date(l);
        System.out.println(d);
        Date date = new Date(new Timestamp(1569287040549l).getTime());
        System.out.println(date);
        System.out.println(new Date().getTime());
    }
    public void insert_batch(){
        getConnection();
        /*String sql = "create table teacher (" +
                "id int primary key," +
                "name varchar(20)," +
                "age int)";*/
       String sql = "insert into teacher (id,name,age) values(?,?,?)";

       try {
            PreparedStatement ps = getPrepareStatement(sql);
             for(int i = 0 ; i<1000;i++){
            ps.setInt(1,i);
            ps.setString(2,"test");
            ps.setInt(3,20);
            ps.addBatch();
            if(i%100==0){
                ps.executeBatch();
            }
            }
             ps.executeBatch();
           // ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

    }
    public void result_test(){
        Teacher t=new Teacher();
        getConnection();
        String sql = "select id,name,age from teacher";
        try {
            getPrepareStatement(sql);
            ResultSet rs = getResultSet();
            /*while (rs.next()){
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setAge(rs.getInt(3));
                System.out.println(t);
            }*/
            /*rs.next();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);
            rs.next();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);*/
            /*rs.first();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);
            rs.last();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);
            rs.absolute(7);
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);*/
            rs.last();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setAge(rs.getInt(3));
            System.out.println(t);
            while(rs.previous()){
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setAge(rs.getInt(3));
                System.out.println(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }
    public void inset_date() throws SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/exejdbc?user=root&password=666888";
        Connection conn = DriverManager.getConnection(url);
        Statement sta = conn.createStatement();
       /*  SimpleDateFormat sd = new SimpleDateFormat();
        String gs = "yyyy-MM-dd";
        sd.applyPattern(gs);
        Date date = new Date();
        String format = sd.format(date);
       String sql = "insert into t_s (id,birth) values ("+1+",'"+format+"')";
        sta.execute(sql);*/
       String sql = "select id,birth from t_s";
        ResultSet resultSet = sta.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            //java.util.Date date = resultSet.getDate(2);
            java.sql.Date date = resultSet.getDate(2);
            System.out.println(date);
        }
        sta.close();
        conn.close();
    }
    public void result_test1(){
        String url  = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888";
        Teacher teacher = new Teacher();
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select id,`name`,age from teacher";
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teacher.setId(rs.getInt(1));
                 teacher.setName(rs.getString(2));
                if(rs.getString(2).equals("test")){
                    rs.updateString(2,"lisi");
                   rs.updateRow();
                }
                teacher.setAge(rs.getInt(3));
                System.out.println(teacher);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        new Date_Batch().result_test1();
    }
}

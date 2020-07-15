package lut.jdbc.jdbc5;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lut.jdbc.jdbc1.Teacher;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/25 11:12
 * @describe dbuntil练习
 **/
public class C3p0_dbUtil {
    public static void main(String[] args) {
        new C3p0_dbUtil().select_MapListHandler();
    }
    /*
    *
    *  //加载文件中的sql 和Properties等价
    //注意存储sql文件放在src下，load中src不写直接"／文件名"
    public void sql_load(){
        try {
            //src/xxx
            Map<String,String> map=QueryLoader.instance()
                    .load("/my.properties");
            String sql=map.get("my");
            System.out.println(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //返回第一行第一列
    public void select_ScalarHandler(){
        Connection conn=null;
        try {
            conn=cpd.getConnection();
            QueryRunner qr=new QueryRunner();
            String sql="select name,id,age " +
                    "from teacher";
            Object obj=
                    qr.query(conn,sql,new ScalarHandler<>());
            System.out.println(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    *
    *
    * */

    public void select_MapListHandler(){
        Connection conn=null;
        try {
            ComboPooledDataSource cpd = new ComboPooledDataSource("mysql");
            conn=cpd.getConnection();
            QueryRunner qr=new QueryRunner();
            String sql="select id,name,age " +
                    "from teacher";
            List<Map<String,Object>> list=
                    qr.query(conn,sql,new MapListHandler());
            for(Map<String,Object> map:list){
                for(Map.Entry<String,Object> en:map.entrySet()){
                    System.out.println(en.getKey()+":"+en.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MapHandler 返回一行记录，对应一个map，把列名作为
    //key ，记录行作为值
    public void select_MapHandler(){
        BasicDataSource bs = new BasicDataSource();
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
        bs.setUrl(url);
        try {
            Connection conn = bs.getConnection();
            QueryRunner q = new QueryRunner();
            String sql = "select id,name,age from teacher where id=?";
            Map<String, Object> map = q.query(conn, sql, new MapHandler(), 1);
            for(Map.Entry<String,Object> m : map.entrySet()){
                System.out.println(m.getKey()+"====="+m.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //将数据库的多行记录存放在list集合中
    //BeanListhandler 返回多行数据，封装成多个对象
    //对象装载在ArrayList集合中
    public void select_BeanListHander(){
        //使用dbcp数据源
        BasicDataSource bs = new BasicDataSource();
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
        bs.setUrl(url);
        try {
            Connection conn = bs.getConnection();
            QueryRunner q = new QueryRunner();
            String sql = "select id,name,age from teacher";
            List<Teacher> lis = q.query(conn, sql, new BeanListHandler<Teacher>(Teacher.class));
            System.out.println(lis);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //只能处理数据库的一行
    //BeanHandler只能处理数据库的一行，只能得到一个对象
    public void select_BeanHander(){
        //使用dbcp数据源
        BasicDataSource bs = new BasicDataSource();
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
        bs.setUrl(url);
        try {
            Connection conn = bs.getConnection();
            QueryRunner q = new QueryRunner();
            String sql = "select id,name,age from teacher where id=1";
            Teacher tea = q.query(conn, sql, new BeanHandler<Teacher>(Teacher.class));
            System.out.println(tea);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select_ResultSetHander_list(){
        ComboPooledDataSource cp = new ComboPooledDataSource();
        cp.setJdbcUrl("jdbc:mysql://localhost:3306/exejdbc");
        cp.setUser("root");
        cp.setPassword("666888");
        try {
            Connection conn = cp.getConnection();
            QueryRunner qr = new QueryRunner();
            String sql = "select * from teacher";
            List<Teacher> list = qr.query(conn, sql, new ResultSetHandler<List<Teacher>>() {
                @Override
                public List<Teacher> handle(ResultSet rs) throws SQLException {
                    ArrayList<Teacher> list1 = new ArrayList<>();
                    while(rs.next()){
                        list1.add(new Teacher(rs.getInt(1),rs.getString(2),rs.getInt(3)));
                    }
                    return list1;
                }
            });
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select_ResultSetHander(){
        ComboPooledDataSource cp = new ComboPooledDataSource("mysql");
        Connection conn = null;
        try {
            conn = cp.getConnection();
            QueryRunner q = new QueryRunner();
            String sql = "select id,name,age from teacher where id=?";
            Teacher teacher= q.query(conn, sql,rs -> {
                Teacher tea=new Teacher();
                if(rs.next()){
                    tea.setId(rs.getInt(1));
                    tea.setName(rs.getString(2));
                    tea.setAge(rs.getInt(3));
                }
                return tea;
            },1);
            System.out.println(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert_test() {
        ComboPooledDataSource co = new ComboPooledDataSource("mysql");
        try {
            Connection conn = co.getConnection();
           // String sql = "delete from teacher";
           /* String sql = "insert into teacher values(" +
                    "1,'李四',30)";*/
          // String sql = "insert into teacher values(?,?,?)";
            QueryRunner qr = new QueryRunner();
           // qr.update(conn,sql);
            String sql = "delete from teacher where id = ?";
            qr.update(conn,sql,2);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

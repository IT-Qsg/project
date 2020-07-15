package lut.jdbc.jdbc1;

import java.sql.*;
import java.util.List;

public class SecondJdbc {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://192.168.43.240:3306/briup";
    private String user="root";
    private String passwd="root";

    public static void main(String[] args) {
//        new SecondJdbc()
//                .pre_insert_test(new Teacher(2,"briup",44));
//        Teacher tea=new Teacher();
//        tea.setAge(55);
//        tea.setName("jake");
//        new SecondJdbc().pre_insert_test1(tea);
//        List<Teacher> list=new ArrayList<>();
//        for(int i=125;i<200;i++){
//            list.add(new Teacher(i,"briup"+i,3));
//        }
        new SecondJdbc().pre_select(3);
    }
    public void pre_select(int id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn=
                    DriverManager.getConnection(url,user,passwd);
            String sql="select id,name username,age from teacher " +
                    "where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                int ids=rs.getInt(1);
                String name=rs.getString("username");
                int age=rs.getInt(3);
                System.out.println(new Teacher(ids,name,age));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void pre_insert_batch(List<Teacher> list){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driver);
            conn=
                    DriverManager.getConnection(url,user,passwd);
            String sql="insert into teacher " +
                    "values(?,?,?)";
            ps=conn.prepareStatement(sql);
            for(Teacher tea:list){
                ps.setInt(1,tea.getId());
                ps.setString(2,tea.getName());
                ps.setInt(3,tea.getAge());
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void pre_insert_test1(Teacher tea){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driver);
            conn=
                    DriverManager.getConnection(url,user,passwd);
            //？表示占位 执行的时候传值
            String sql="insert into teacher " +
                    "values(3,?,?)";
            ps=conn.prepareStatement(sql);
            //setXXX给values里面的问号设置值
            //第一个参数表示问号的位置，换言之第几个问号
            ps.setString(1,tea.getName());
            ps.setInt(2,tea.getAge());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public void pre_insert_test(Teacher tea){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driver);
            conn=
                    DriverManager.getConnection(url,user,passwd);
            //？表示占位 执行的时候传值
            String sql="insert into teacher " +
                    "values(?,?,?)";
            ps=conn.prepareStatement(sql);
            //setXXX给values里面的问号设置值
            //第一个参数表示问号的位置，换言之第几个问号
            ps.setInt(1,tea.getId());
            ps.setString(2,tea.getName());
            ps.setInt(3,tea.getAge());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
    public void pre_insert_test(){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName(driver);
            conn=
                    DriverManager.getConnection(url,user,passwd);
            String sql="insert into teacher " +
                                "values(1,'lisi',30)";
            ps=conn.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                try {
                    if(ps!=null)ps.close();
                    if(conn!=null)conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }
}












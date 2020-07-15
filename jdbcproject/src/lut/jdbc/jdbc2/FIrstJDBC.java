package lut.jdbc.jdbc2;

import lut.jdbc.jdbc1.Teacher;

import java.sql.*;
import java.util.List;

public class FIrstJDBC {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://192.168.43.240:3306/briup?" +
            "user=root&password=root&useUnicode=true&" +
            "characterEncoding=UTF8";
    public static void main(String[] args) {
//        new FIrstJDBC().JDBC_test();
//        new FIrstJDBC().insert_test();
//        List<Teacher> list=new ArrayList<>();
//        for(int i=3;i<100;i++) {
//            list.add(new Teacher(i, "jake"+i, 1+i));
//        }
//        new FIrstJDBC().insert_batch1(list);
        //new FIrstJDBC().select_test();
//        for(int i=2;i<90;i++) {
//            new FIrstJDBC().delete_test(i);
//        }
        new FIrstJDBC().update_test(
                new Teacher(99,"tom",22));
    }
    public void update_test(Teacher tea){
        Connection conn=null;
        Statement sts=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url);
            sts=conn.createStatement();
            String sql="update teacher " +
                    "set name='"+tea.getName()+"'," +
                    "age="+tea.getAge()+" where id="+tea.getId();
            sts.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(sts!=null)sts.close();
                if(conn!=null)conn.close();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }

    }
    public void delete_test(int id){
        Connection conn=null;
        Statement sts=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url);
            sts=conn.createStatement();
            String sql="delete from teacher where id="+id+"";
            sts.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(sts!=null)sts.close();
                if(conn!=null)conn.close();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }

    }
    public void select_test(){
        Connection conn=null;
        Statement sts=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url);
            sts=
                conn.createStatement();
            String sql="select id,name,age " +
                         "from teacher";
            rs=sts.executeQuery(sql);
            //第五步，处理结果集
            //rs.next()判断下一行是否有值
            while(rs.next()){
                //参数数字表示的是select后面的位置
                //取值用的都是getXXX() xxx表示类型
                //该类型java中对应的类型
//                int id=rs.getInt(1);
//                String name=rs.getString(2);
//                int age=rs.getInt(3);
//                System.out.println("id="+id+",name="+name+",age="+age);
                //基于列名取值
                int id=rs.getInt("id");
                String name =rs.getString("name");
                int age=rs.getInt("age");
                System.out.println("id="+id+",name="+name+",age="+age);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(sts!=null)sts.close();
                if(conn!=null)conn.close();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }
    public void insert_batch1(List<Teacher> list){
        Connection conn=null;
        Statement sts=null;
        try {
            //注册注册
            Class.forName(driver);
            //链接
            conn=
                    DriverManager.getConnection(url);
            //构建Statemement对象
            sts=conn.createStatement();
            for(Teacher tea:list) {
                String sql = "insert into teacher " +
                        "values("+tea.getId()+",'"
                        +tea.getName()+"',"+tea.getAge()+")";
                sts.executeUpdate(sql);
            }
            if(sts!=null)sts.close();
            if(conn!=null)conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(sts!=null)sts.close();
                if(conn!=null)conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
    public void insert_test(){
        Connection conn=null;
        Statement sts=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url);
            sts=conn.createStatement();
            String sql="insert into teacher values(1,'lisi',30)";
            //executeUpdate  返回int影响数据库的行计数
            sts.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(sts!=null)
                        sts.close();
                    if(conn!=null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


    public void JDBC_test(){
        try {
            //第一种方式注册驱动
//            Driver driver=new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
            //第二种方式注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //第三种注册驱动，给虚拟机传参数
//            System.setProperty("jdbc.drivers",
//                        "com.mysql.jdbc.Driver");
            //第四种注册驱动，运行程序的时候给虚拟机传参数
            //第二步获取链接
//            Connection conn=
//            DriverManager.getConnection(
//                    "jdbc:mysql://192.168.43.240:3306/briup",
//                        "root",
//                        "root");
            //第二步第二种获取链接
//            Properties pro=new Properties();
//            pro.setProperty("user","root");
//            pro.setProperty("password","root");
//            Connection conn=
//                    DriverManager.getConnection(
//                    "jdbc:mysql://192.168.43.240:3306/briup",
//                                pro);
            String url="jdbc:mysql://192.168.43.240:3306/briup?" +
                    "user=root&password=root&useUnicode=true&" +
                    "characterEncoding=UTF8";
            //第二步第三种获取链接
            Connection conn=
                    DriverManager.getConnection(url);
            //第二步第三种获取链接
            System.out.println(conn);
            //第三步构建Statement对象
            Statement sts=
                 conn.createStatement();
            String sql="create table teacher(" +
                    "id int primary  key," +
                    "name varchar(20)," +
                    "age tinyint " +
                    ")";
            //第四步：执行sql语句
            //execute执行的时候返回boolean类型
            //执行的sql语句有结果返回才为true，否则都是false
            sts.execute(sql);
            //先开的后关,第六步关闭资源
            if(sts!=null)sts.close();
            if(conn!=null)conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

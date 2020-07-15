package lut.jdbc.jdbc4;

import java.io.*;
import java.sql.*;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/24 21:23
 * @describe
 **/
public class Text_Blob {
    //创建表
    public void createTable(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement sta = conn.createStatement();
            String sql = "create table text_test(" +
                    "id int primary key," +
                    "big_text text)";
            sta.execute(sql);
            sta.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert_file(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true?characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into text_test" +
                    "(id,big_text) values (2,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            FileReader fr = new FileReader(new File("src\\lut\\jdbc\\jdbc4\\Text_Blob.java"));
            char[] chars = new char[100];
            int len;
            String s = "";
            while((len=fr.read(chars))!=-1){
                s+=new String(chars).toString();
            }
            ps.setString(1,s);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void select_file(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true?characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select big_text from text_test where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,2);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                System.out.println(rs.getString(1));
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert_file2(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true?characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into text_test" +
                    "(id,big_text) values (3,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            FileReader fr = new FileReader(new File("src\\lut\\jdbc\\jdbc4\\Date_Batch.java"));
            ps.setCharacterStream(1,fr);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void select_file2(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true?characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select big_text from text_test";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               /* Reader re = rs.getCharacterStream(1);
                char[] chars = new char[100];
                int len;
                while((len=re.read(chars))!=-1){
                    System.out.println(new String(chars,0,len));
                }*/
                String string = rs.getString(1);
                System.out.println(string);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void insert_picture(){
        /*
         create table b_test(
    -> id int primary key,
    -> picture mediumblob
    -> );
        * */
        String url = "jdbc:mysql://localhost:3306/exejdbc?user=root&password=666888&userUnicode=true&characterEncodeing=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql="insert into b_test (id,picture) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            FileInputStream fis = new FileInputStream(new File("src\\English.png"));
            ps.setBlob(2,fis);
            ps.executeUpdate();
            fis.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void select_picture(){
        String url = "jdbc:mysql://localhost:3306/exejdbc?&user=root&password=666888&userUnicod=true&characterEncoding=UTF8";
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select picture from b_test";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Blob blob = rs.getBlob(1);
                InputStream inp = blob.getBinaryStream();
                byte[] bytes = new byte[1024];
                int len;
                FileOutputStream fos = new FileOutputStream(new File("src\\lut\\jdbc\\jdbc4\\2.png"));
                while ((len=inp.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                    fos.flush();
                }
                fos.close();
                inp.close();
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Text_Blob().select_picture();
    }
}

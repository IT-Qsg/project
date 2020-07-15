package lut.jdbc.jdbc3;

import java.io.*;
import java.sql.*;

/*
create table text_test(
id int primary key,
big_text text
);
create table b_test(
id int primary key,
big_blob longblob
 );
 */
public class TextBlob {
    private String driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String passwd="root";
    private String url="jdbc:mysql://192.168.43.240:3306/briup";

    public static void main(String[] args) {
        new TextBlob().blob_img_ps();
    }
    public void blob_img_ps(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,passwd);
            //String sql="insert into b_test values(2,?)";
            String sql="select * from b_test";
            ps=conn.prepareStatement(sql);
//            FileInputStream fis=
//                    new FileInputStream(
//                            new File("src/1.png"));
//            ps.setBlob(1,fis);
//            ps.execute();
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                if(id==1){
                    System.out.println(rs.getString(2));
                }else{
                    InputStream is=rs.getBinaryStream(2);
                    byte [] c=new byte[1024*1024];
                    int len;
                    File file=new File("src/com/briup/2.png");
                    if(!file.exists())file.createNewFile();
                    FileOutputStream fos=new FileOutputStream(file);
                    while((len=is.read(c))!=-1){
                        fos.write(c,0,len);
                        fos.flush();
                    }
                    fos.close();
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











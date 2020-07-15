package Sever3;

import Sever3.util.Finder;
import sever2.util.Log;

import java.io.*;
import java.net.Socket;

public class ResponseImp {
    /*
    * socket,url,ps
	  resourcePath,errorFile,welFile
    *
    * */

    private PrintStream ps;
    private Socket sc;
    private String url;
    private String resourcePath;
    private String errorFile;
    private String welFile;
    private File file;
    public ResponseImp(Socket sc,String url) throws IOException {
        this.url = url;
        this.sc = sc;
        this.ps = new PrintStream(this.sc.getOutputStream(),true);
        //获得资源路径
        file = new File(Finder.getValudOf("Resoutcepath"),url);
        errorFile = Finder.getValudOf("Resoutcepath")+"\\"+Finder.getValudOf("errorFile");
        welFile =Finder.getValudOf("Resoutcepath")+"\\"+ Finder.getValudOf("welFile");
    }
    /*
    * 生成响应行
    * */
    public String getResLine(){
        String s = null;
        if(file.exists()){
            s = "HTTP/1.1 200 "+Finder.getValudOfstatus("200");
            if("/".equals(url)){
                file = new File(welFile);
            }
        }else{
            s = "HTTP/1.1 404 "+Finder.getValudOfstatus("404");
            file = new File(errorFile);
        }
        return s;
    };
    //生成响应头
    public String getResHeader(){
        String strHead = null;
        String[] split = url.split("[.]");
        String end = split[split.length-1];
        Log.logger().info("后缀："+end);
        if("".equals(end)){
            Log.logger().info("文件后缀为空");
            try {
                throw new IOException("文件后缀为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        strHead ="Content-Type: "+Finder.getValudOfmime(end)+"; charset=UTF-8";
        return strHead;
    };
    //发送响应体
    public void sendResBody() throws IOException {
        FileInputStream fi = new FileInputStream(file);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fi.read(bytes,0,bytes.length))!=-1){
            ps.println(new String (bytes,0,length));
        }
        fi.close();
        ps.close();
    };
    public void sendHttpResource() throws IOException {
        String resLine = getResLine();
        //发送相应行
        ps.println(resLine);

        //发送响应头
        String resHeader = getResHeader();
        ps.println(resHeader);

        //发送空行
        ps.println();
        //发送响应体
        sendResBody();
    }

  /*  public static void main(String[] args) {
        String s = ".jshfjs.";
        //String[] split = s.split("\\.");
        String[] split = s.split("[.]");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }*/
}

package sever1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(120);
        //服务器资源路径
        String path = "D:\\ideaIU\\project\\javaProject\\src\\sever1.resource";
        File file = new File(path);
        System.out.println("服务器已经启动！");
        Socket sc = ss.accept();
        if(sc ==null){

        }else{
            System.out.println("客户端已经连接\n" +
                    "address："+sc.getInetAddress().getHostAddress());
        }
        PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String s = br.readLine();
        String s2 = spl(s);
        if("/".equals(s2)) {
            //发送信息为空,跳转到欢迎页面
            pw.println("HTTP/1.1 200 OK");
            pw.println();

            File f3 = new File(file,"wel.html");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f3)));
            String s3;
            while((s3 = br.readLine())!=null){
                pw.println(s3);
            }

        }else {
            //发送状态行
            pw.println("HTTP/1.1 200 OK");
            pw.println();
            File  file2  = new File(file,s2);
            if(file2.exists()){
               //存在便发送
               //发送相应文本信息
               br = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
               String s3;
               while((s3 = br.readLine())!=null){
                   pw.println(s3);
               }
           }else{
               //发送文件不存在即为出错
               File f3 = new File(file,"error.html");
               br = new BufferedReader(new InputStreamReader(new FileInputStream(f3)));
               String s3;
               while((s3 = br.readLine())!=null){
                   pw.println(s3);
               }
           }
        }

    }
    static public String spl(String s) throws IOException {
        String[] s1 = s.split(" ");
        if(s1.length!=3){
            System.out.println("输入异常");
            throw new IOException("输入异常");
        }else {

            return s1[1];
        }
    }
}

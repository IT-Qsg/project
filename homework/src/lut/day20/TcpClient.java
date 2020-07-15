package lut.day20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("localhost",12345);//客户端连接服务端
        OutputStream os = cs.getOutputStream();
        PrintWriter pw = new PrintWriter(os,true);
        pw.println("Hello,服务器，逗你玩 ");
        InputStream inputStream = cs.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        br.close();
        inputStream.close();

        pw.close();
        os.close();
        cs.close();
    }
}
class TcpServer{
    public static void main(String[] args) throws IOException {

            ServerSocket ss = new ServerSocket(1234);
            System.out.println("服务器启动了");
        // 通过服务端的ServerSocket对象获取服务器的IP地址
             String sIP=ss.getInetAddress().getHostAddress();
             System.out.println("服务 "+sIP+" 器启动了！！！");

            Socket cs = ss.accept();
            InputStream inputStream = cs.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String s = br.readLine();
            System.out.println(s);

            OutputStream outputStream = cs.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream,true);
            String s1 = s.toUpperCase();
            pw.println(s1);

             pw.close();
             outputStream.close();

             br.close();
             inputStream.close();
             cs.close();
             ss.close();
    }
}
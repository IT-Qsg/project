package lut.day20.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
*
*          1.客户端循环发，服务器循环接收；
*
* */
public class H1 {}
class ClientManage{
    public static void main(String[] args) throws IOException {
        //创建客户端对象。用于连接服务器
        Socket sc = new Socket("127.0.0.1",1100);
        //客户端发送数据
        OutputStream os= sc.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        while(true){
        bw.write("累死你！");
        bw.newLine();
            System.out.println("客户端------》》累死你！");
        bw.flush();
        }
       // bw.close();//执行不到

    }
}
class Serve{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1100);
        Socket accept = ss.accept();
        InputStream in = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while(true){
            String s = br.readLine();
            System.out.println("服务器端----》》"+s);
        }
    }
}
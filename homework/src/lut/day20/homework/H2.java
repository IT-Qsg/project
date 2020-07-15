package lut.day20.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 2.基于TCP的聊天系统；
public class H2 {}
class ClientC1{
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1",11);
        OutputStream outputStream = sc.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = sc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while(true){
            String s = bw.readLine();
         //   char[] c = new char[50];

         //   pw.write(s);
            pw.println(s);
            //System.out.println("客户1：："+s);
            pw.flush();
            String s1 = br.readLine();
            System.out.println(s1);
        }
    }
}
class ClientC2{
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1",10);
        InputStream inputStream = sc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = sc.getOutputStream();

        PrintWriter pw = new PrintWriter(outputStream,true);
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
       while(true){
         //  char[] c = new char[50];
           String s = br.readLine();
           System.out.println(s);
           String s1 = bw.readLine();
           pw.println(s1);
       }
    }
}
class ServerM{
    public static void main(String[] args) throws IOException {
        //客户以----》》客户二
        ServerSocket ss1 = new ServerSocket(11);
        ServerSocket ss2 = new ServerSocket(10);

        Socket accept = ss1.accept();
        Socket accept1 = ss2.accept();

        InputStream in = accept.getInputStream();
        OutputStream outputStream = accept1.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(outputStream,true);

        //客户二----》》客户一
        InputStream inputStream = accept1.getInputStream();
        OutputStream outputStream1 = accept.getOutputStream();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter pw2 = new PrintWriter(outputStream1,true);

        while(true){
         //   char[] c = new char[50];
            String s = br.readLine();
            System.out.println("客户1：："+s);
            //pw.write(s);
            pw.println(s);

            String s1 = br2.readLine();
            pw2.println(s1);
            System.out.println("客户2：："+s1);
        }
    }
}

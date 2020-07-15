package lut.day21.exe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PracticeTest3 {
}
class Server3{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(65432);

        while(true){
            //accept();//阻塞式方法
            Socket cs = ss.accept();
            String cIP=cs.getInetAddress().getHostAddress();
            System.out.println("客户端："+cIP+"连接到服务器！！");
            new Thread(()->{
                try {
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(cs.getInputStream()));
                  //  String s ;//= br.readLine();

                    while(true){
                      String  s = br.readLine();
                        if(s.equals(""))
                            System.out.println("输入内容为空！！");
                        else
                            System.out.println(cIP+"  说\t"+s);
                        if("886".equals(s)){
                            System.out.println(cIP+"断开连接");
                            break;
                        }
                    }
                    br.close();
                    cs.close();
                } catch (IOException e) {
                   // e.printStackTrace();
                   // System.out.println(cIP+"断开连接");
                }
            }).start();
        }
    }
}
class Client3{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",65432);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream,true);
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        String s ;

        while((s= br.readLine())!=null){
            printWriter.println(s);
            if("886".equals(s))break;
        }
    }

}
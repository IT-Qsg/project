package lut.day21.exe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(123);
        Socket accept = ss.accept();
       // InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream(),true);

        String s;
        while((s= bufferedReader.readLine())!=null){
            System.out.println(s);
            printWriter.println("客户端，你好");
            if("886".equals(s))break;
        }
        printWriter.close();
        bufferedReader.close();
        accept.close();
        ss.close();

    }
}
class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",123);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream,true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int i =0;
        while(true){
            if(i==10){printWriter.println("886");
            break;}
            printWriter.println("你好，服务器！");
        String s = bufferedReader.readLine();
            System.out.println(s);
            i++;

        }

    }
}

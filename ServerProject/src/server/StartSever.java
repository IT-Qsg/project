package server;

import Util.finder.Finder;
import server.ThreadSever.serverRunable;
import server.req_resp_Imp.RequestImp;
import server.req_resp_Imp.ResponImp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartSever {
    private int server_port;//端口
    public StartSever(){
        server_port = Integer.parseInt(
                Finder.getValudOfconfig("severPort"));//对端口做初始化

        try {
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //和客户端做交互的方法
    private void receive() throws IOException {
        //1.创建服务器
        ServerSocket server = new ServerSocket(server_port);

        while (true) {
            Socket socket = server.accept();
            RequestImp ri = new RequestImp(socket);
            ResponImp re = new ResponImp(ri);
            new Thread(new serverRunable(re,ri)).start();

        }
    }

    public static void main(String[] args) {
        /*StartSever startSever = new StartSever();
        System.gc();*/
    }
}

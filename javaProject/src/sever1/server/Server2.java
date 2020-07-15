package sever1.server;

import sever1.Util.ProperFindder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
            int severPort;

            public Server2(String severPort) {
                this.severPort = Integer.parseInt(ProperFindder.getValudOf(severPort));
            }
            void receive() throws IOException {
                //创建服务器
                ServerSocket ss = new ServerSocket(severPort);
                new Thread(new MyRunable(ss.accept())).start();
            }
            public static void main(String[] args){}
}
class MyRunable implements Runnable{
            private String Resourcepath;
            private String errorFile;
            private String welFile;
            private  Socket sc ;
           public MyRunable(Socket sc) {
                this.sc = sc;
                Resourcepath = ProperFindder.getValudOf("Resoutcepath");
                errorFile = ProperFindder.getValudOf("errorFile");
                welFile = ProperFindder.getValudOf("welFile");
            }
            @Override
            public void run() {

            }

            private String getUrl (String s){
               return null;
            }
}
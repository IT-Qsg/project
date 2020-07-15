package lut.day20.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 3.多线程聊天；
public class H3 {

}
class ServerSoc{
    ServerSocket sock;
    String name;
    Socket sc;
    public ServerSoc(Socket sc, String name){

        this.sc = sc;
        this.name = name;
    }
    //多线程创建
    public ServerSocket createSock() throws IOException {
        int port = sc.getPort();
        ServerSocket ss = new ServerSocket(port);
        return ss;
    }
    public void createSerThread() {
        while (true){
            new Thread(() -> {
                try {
                    sock = createSock();
                    Socket accept = sock.accept();
                   InputStream inputStream = accept.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    String s = br.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, name).start();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
    }
}
package Sever3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(120);
        while (true){
                   Socket accept = ss.accept();
                    requestImp requestImp = new requestImp(accept);
                    ResponseImp responseImp = new ResponseImp(accept, requestImp.getUrl());
                    responseImp.sendHttpResource();
        }

    }
}

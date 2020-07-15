package Exe.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class GroupStart {
    DatagramSocket ds;
    public GroupStart(){
        try {
            ds = new DatagramSocket(10);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public void startSock() throws IOException {
       //接受端只需要根据端口号接收数据
        byte [] data = new byte[1024*64];
        int datalength = data.length;
        DatagramPacket dp = new DatagramPacket(data,datalength);
        //一直接收
        while(true){
            ds.receive(dp);
            byte[] data1 = dp.getData();
            int len = data1.length;
            String s = new String(data1,0,len);
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        try {
            new GroupStart().startSock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Cinent{
    DatagramPacket dp;
    DatagramSocket ds;
    InetAddress address;
    int port;
    public Cinent(InetAddress address,int port) throws UnknownHostException, SocketException {
        ds= new DatagramSocket();
       // InetAddress address = InetAddress.getByName("127.0.0.1");
       // int port = 10;
        this.address = address;
        this.port = port;
    }
    public void send() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //一直发送
        while(true){
            String s = br.readLine();
            byte[] bytes= s.getBytes();
            int len = bytes.length;
            dp = new DatagramPacket(bytes,len,address,port);
            ds.send(dp);
        }
    }

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10;
        new Cinent(address,port).send();
    }
}class Cinent2{
    DatagramPacket dp;
    DatagramSocket ds;
    InetAddress address;
    int port;
    public Cinent2(InetAddress address,int port) throws UnknownHostException, SocketException {
        ds= new DatagramSocket();
       // InetAddress address = InetAddress.getByName("127.0.0.1");
       // int port = 10;
        this.address = address;
        this.port = port;
    }
    public void send() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //一直发送
        while(true){
            String s = br.readLine();
            byte[] bytes= s.getBytes();
            int len = bytes.length;
            dp = new DatagramPacket(bytes,len,address,port);
            ds.send(dp);
        }
    }

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10;
        new Cinent2(address,port).send();
    }
}
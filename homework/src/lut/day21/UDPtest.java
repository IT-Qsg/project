package lut.day21;

import java.io.IOException;
import java.net.*;

public class UDPtest {
}
class Sender{
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte [] data ="你好".getBytes();
        int length = data.length;
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 1234;
        DatagramPacket datagramPacket = new DatagramPacket(data,length,byName,port);
        ds.send(datagramPacket);
    }
}
class Receive{
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1234);
        byte [] bytes = new  byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes, length);
        //阻塞式方法
        ds.receive(dp);
        byte[] data = dp.getData();
        int length1 = dp.getLength();
        System.out.println(new String(data,0,length1));

    }
}
package lut.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDESend {
    public static void main(String[] args) throws IOException {
        //发数据
        DatagramSocket ds = new DatagramSocket();
        //往哪里发
        InetAddress byName = InetAddress.getByName("192.168.204.255");
        int port = 110;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //一直发
        while(true){
            String s = br.readLine();
            byte[] bytes = s.getBytes();
            int length = bytes.length;
            DatagramPacket dp = new DatagramPacket(bytes,length,byName,port);
            ds.send(dp);
        }

    }
}
class UDESend1 {
    public static void main(String[] args) throws IOException {
        //发数据
        DatagramSocket ds = new DatagramSocket();
        //往哪里发
        InetAddress byName = InetAddress.getByName("192.168.204.1");
        int port = 110;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //一直发
        while(true){
            String s = br.readLine();
           // if("".equals(s)) System.out.println("内容为空");
            byte[] bytes = s.getBytes();
            int length = bytes.length;
            DatagramPacket dp = new DatagramPacket(bytes,length,byName,port);
            ds.send(dp);
        }

    }
}
class UDESend2 {
    public static void main(String[] args) throws IOException {
        //发数据
        DatagramSocket ds = new DatagramSocket();
        //往哪里发
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 110;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //一直发
        while(true){
            String s = br.readLine();
           // if("".equals(s)) System.out.println("内容为空");
            byte[] bytes = s.getBytes();
            int length = bytes.length;
            DatagramPacket dp = new DatagramPacket(bytes,length,byName,port);
            ds.send(dp);
        }

    }
}
class UDPReceive{
    public static void main(String[] args) throws SocketException {
        //接收数据
        DatagramSocket datagramSocket = new DatagramSocket(110);
        byte[] bytes = new byte[1024*64];
        int length = bytes.length;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,length);
        while (true){
            try {

                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String s = new String(data);
               // if(s.equals("\r\n")) System.out.println("内容是空");
                //else
                System.out.println(datagramPacket.getAddress().getHostAddress()+"说："+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
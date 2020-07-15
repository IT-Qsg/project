package lut.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPTest3 {
    public static void main(String[] args) {
        new SendThread().start();
        new ReceiveThread().start();
    }

}
class SendThread extends Thread{


    @Override
    public void run() {
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            int port = 45678;
            DatagramSocket ds = new DatagramSocket();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while(true){
                line = reader.readLine();
                if(line ==null)continue;
                if("886".equals(line))break;
                byte [] bytes = line.getBytes();
                int length = bytes.length;
                DatagramPacket datagramPacket = new DatagramPacket(bytes,length,byName,port);
                ds.send(datagramPacket);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ReceiveThread extends  Thread{
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(45678);
            byte [] bytes = new byte[1024*64];
            int length = bytes.length;
            DatagramPacket datagramPacket = new DatagramPacket(bytes,length);
            while(true){
            ds.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length1 = data.length;
            System.out.println(new String(data,0,length1));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
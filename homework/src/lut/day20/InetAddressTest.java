package lut.day20;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("localhost");
        String ha = ia.getHostAddress();
        String hostName = ia.getHostName();
        System.out.println(ha+":::"+hostName);

    }
}

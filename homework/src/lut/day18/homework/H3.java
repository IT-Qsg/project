package lut.day18.homework;

import java.io.*;

public class H3 {
    public static void main(String[] args) throws IOException {
        DataInputStream inputStream =
                new DataInputStream(
                        new FileInputStream(
                                new File("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\config.txt")));

        int read = inputStream.readInt();
        System.out.println(read);
        if(read<=0){
            System.out.println(read);
            System.out.println("产品已经到期,请购买正版");
            inputStream.close();
        }else{
            DataOutputStream output =
                new DataOutputStream(
                        new FileOutputStream(
                                new File("C:\\Users\\qsg\\Desktop\\bd1904祁世刚\\day18\\countSub.txt")));
            output.writeInt(--read);
            output.flush();
            output.close();
        }

    }
}

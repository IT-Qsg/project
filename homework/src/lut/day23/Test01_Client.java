package lut.day23;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test01_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        String file = getFile();
        //String file = "E:\\BD1904\\src\\com\\briup\\java\\day20\\note\\note_day20";
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());

        File filepath = new File(file);
        String name = filepath.getName();

        ps.println(name);

        //获取客户端的反馈
        String msg = br.readLine();
        if ("true".equals(msg)){
            System.out.println("服务器已经存在改文件，不需要再次发送");
            socket.close();
            return;
        }else if ("false".equals(msg)){
            //服务器不存在改文件，上传
            FileInputStream fis = new FileInputStream(filepath);

            int len;
            while ((len = fis.read())!=-1){
                ps.write(len);
            }
            fis.close();
            System.out.println("文件上传结束");
            socket.close();

        }

    }


    //从键盘通过路径名获取一个文件名
    public static String getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个路径名");

        String fileName ;//= "E:\\BD1904\\src\\com\\briup\\java\\day20\\note\\note_day20";
        while (true) {
            fileName = sc.nextLine();
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("路径名不存在，请重新输入");
            } else if (file.isDirectory()) {
                System.out.println("是文件夹，重新输入");
            }
            else {
                break;
            }
        }
        return fileName;
    }
}

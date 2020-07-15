package lut.day23;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yfl
 * \* Date: 2019/8/20
 * \* Time: 23:10
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Test01_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("服务器已经启动....，端口：" + 9999);

        while (true){
            Socket socket = server.accept();
            String ip = socket.getInetAddress().getHostName();
            int port = socket.getPort();
            System.out.println("客户端..." + ip + ":" + port + "已连接");

            new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        String filename = br.readLine();
                        //去指定的服务器资源目录中查看文件是否存在
                        File file = new File("E:\\", filename);
                        if (file.exists()){
                            System.out.println("客户端发送的文件名" + filename + "在本地资源中已经存在");
                            ps.println("true");
                            return;
                        }else {
                            //文件不存在，先发送一个标志，然后创建一个同名的本地文件
                            ps.println("false");
                            FileOutputStream fos = new FileOutputStream(file);
                            byte[] bytes = new byte[1024 * 8];
                            int len;
                            while ((len = is.read(bytes)) != -1){
                                fos.write(bytes,0,len);
                            }
                            fos.close();
                            System.out.println("读取数据完成，上传文件结束");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if (socket == null){
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }.start();

        }
    }
}
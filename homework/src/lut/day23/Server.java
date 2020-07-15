package lut.day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10);
       while(true){
            Socket sc = ss.accept();
            String address = sc.getInetAddress().getHostAddress();
            int port = sc.getPort();
            System.out.println("地址："+address+"端口："+port);
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        InputStream input = sc.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(input));

                        OutputStream output = sc.getOutputStream();
                        PrintStream pw = new PrintStream(output);

                        String filename = br.readLine();
                        File fname = new File("E:\\"+filename);


                        if(!fname.exists()){
                            pw.println("true");
                            //接收
                           /* byte[] c = new byte[1024];
                            int len = c.length;
                            int read ;
                          //  BufferedInputStream bi = new BufferedInputStream(input);
                            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(fname));
                            while((input.read(c))!=-1){
                                bw.write(c);
                                bw.flush();

                            }*/
                            byte[] bytes = new byte[1024 * 8];
                            int len;
                            FileOutputStream fos = new FileOutputStream(fname);
                            while ((len = input.read(bytes)) != -1){
                                fos.write(bytes,0,len);
                            }
                            System.out.println("读取数据完成，上传文件结束");
                            fos.close();
                            //System.out.println(filename);
                            //input.close();
                            //bw.close();
                        }else{
                            System.out.println("文件已经存在");
                            pw.println("false");
                            return;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(sc==null){
                            try {
                                sc.close();
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
class Client{
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1",10);
        File fileName = new Client().getFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        PrintStream pr = new PrintStream(sc.getOutputStream());

        pr.println(fileName.getName());


        String tf = br.readLine();
        System.out.println(tf);
        if("true".equals(tf)){
            FileInputStream fi = new FileInputStream(fileName);
           // byte[] bytes =new byte[1024];
            int read ;
           while((read = fi.read())!=-1)
           {
               pr.write(read);
           }
           System.out.println("文件已经上传");
           fi.close();
           sc.close();
        }else {
            System.out.println("文件已经存在");
            pr.close();
        }
    }
    public File getFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入文件路径：");
             String filePath = br.readLine();
            File file = new File(filePath);
           if(file.isFile()){
                return file;
            }
            if(file.isDirectory()){
                System.out.println("所输入的指定路径是文件夹");
                return getFile();
            }
            //if(!file.exists()){
            System.out.println("文件不存在，请重新输入");
            return getFile();
          // }

       /* File file;
        while(true){
            String filePath = br.readLine();
            file = new File(filePath);
        }*/


    }
}



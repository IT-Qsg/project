package lut.day20.homework2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class H1 {
}
/*
* 1.客户端向服务器上传文件
	客户端
    2.提示输入要上传的文件路径File，验证路径是否有效，以及是否是文件夹，不存在或是文件夹都需要重新录入
    3.发送文件名到服务器  File.getName
    6.接收结果，如果存在给予提示，否则程序直接退出
    7.如果存在，定义FileInputStream读取文件，通过网络上传

    服务器
    1.建立多线程服务器
    4.读取文件名
    5.判断文件名是否存在，将结果返回给客户端
    8.接收文件
* */
class FileCin{
    public static void main(String[] args) throws IOException {
        Socket ac = new Socket("localhost",110);
        FileCin fc = new FileCin();
        File file = fc.checkFile();
       // fc.inpServer(file,ac);
        //传送文件名
        String Filename = file.getPath();
        OutputStream outputStream = ac.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);
        pw.println(Filename);
        System.out.println(Filename);

        InputStream inputStream = ac.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        String s2 = br.readLine();
        System.out.println(s2);

       /* br.close();
        inputStream.close();
        pw.close();
        outputStream.close();
        ac.close();*/

    }
    //判断是不是文件
    public File checkFile() throws IOException {
        System.out.println("请输入文件全名称：");
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        String s = br.readLine();
        File file = new File(s);
        if(file.isDirectory()){
            System.out.println("指定路径是文件夹，不是文件，请重新输入...");
            return checkFile();
        }
        if(file.isFile()) {
            System.out.println("文件正确，正在上传服务器。。。");
            br.close();
            inp.close();
            return file;
        }else{
            System.out.println("指定路径无效，请重新输入...");
            return checkFile();
        }
    }
    //上传服务器
    /*public void inpServer(File file,Socket ac) throws IOException {
        //FileInputStream fin = new FileInputStream(file);
        //BufferedInputStream bfi = new BufferedInputStream(fin);

        //传送文件名
        String Filename = file.getName();
        OutputStream outputStream = ac.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);
        pw.println(Filename);

        InputStream inputStream = ac.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        br.close();
        inputStream.close();
        pw.close();
        outputStream.close();
        ac.close();
    }*/

}
class ServFile{
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket ss =new ServerSocket(110);
        //接受文件名
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        File file = new File(s);
        OutputStream outputStream = accept.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream,true);
        if(file.isFile()){
            //返回结果至客户端
            pw.println("正在上传文件");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

        FileOutputStream fo = new FileOutputStream("E:\\b.java");
        BufferedOutputStream bus = new BufferedOutputStream(fo);

        byte[] b = new byte[1024];
        int length;
        while((length = bis.read(b))!=-1){
            bus.write(b,0,length);
        }
        pw.println("文件上传成功");

        bus.close();
        fo.close();
        bis.close();
        fileInputStream.close();
        pw.close();
        outputStream.close();
        br.close();
        inputStream.close();
        ss.close();

    }
}
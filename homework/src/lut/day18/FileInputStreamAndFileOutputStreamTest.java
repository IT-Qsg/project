package lut.day18;

import java.io.*;

public class FileInputStreamAndFileOutputStreamTest {
    public static void main(String[] args) throws IOException {
      //  ReadFile();
      // writeFile();
        //copyFile("D:\\ideaIU\\project\\homework\\src\\a.txt","D:\\ideaIU\\project\\homework\\src\\b.txt",false);
         remove("D:\\ideaIU\\project\\homework\\src\\a.txt","D:\\ideaIU\\project\\homework\\src\\b.txt");
    }
    static void ReadFile() throws IOException {
        File file = new File("C:\\Users\\qsg\\Desktop\\线程作业答案\\线程作业答案\\homework02\\Test01.java");

        FileInputStream fis = new FileInputStream(file);

        byte[] bytes = new byte[1024];
        while(true){
            int read = fis.read(bytes);
            if(read==-1)break;
            String ss = new String(bytes,0,read);
            System.out.println(ss);
        }
        fis.close();
    }
    static void writeFile() throws IOException {
        File file = new File("D:\\ideaIU\\project\\homework\\src\\a.txt");
        OutputStream fos = new FileOutputStream(file);
        byte[] bytes = "文件写".getBytes();
        fos.write(bytes);
    }
    static void copyFile(String srcPath,String outPath,Boolean append) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        //设置缓冲区
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(outPath,append);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int length;
        while((length=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,length);
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();

    }
    static void remove(String srcPath,String outPath) throws IOException {
        copyFile(srcPath, outPath, false);
        new File(srcPath).delete();
    }

}

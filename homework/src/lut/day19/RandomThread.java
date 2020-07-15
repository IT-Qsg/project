package lut.day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomThread {
    public static void main(String[] args) throws IOException {
        File f =  new File("E:\\a.java");
        RandomAccessFile r = new RandomAccessFile(f,"rw");
        AccessFile ac = new AccessFile(r,f);
        ac.read();
    }
}
class AccessFile{
    RandomAccessFile raf;
    File endPath;
    File file = new File("E:\\c.txt");
    RandomAccessFile ref = new RandomAccessFile(file,"rw");
    public AccessFile(RandomAccessFile raf,File endpath) throws FileNotFoundException {
        this.raf = raf;
        this.endPath = endpath;
    }
    public void read() throws IOException {
        long length = raf.length();
        ref.setLength(length);
       // System.out.println(length);
        long readlength = length / (long)Math.pow(20,2);
        //System.out.println(readlength);
        int i  = 0;
        for(;i<readlength;i++){
            System.out.println(i);
            int skeptByte =(int) readlength*i;
            new Thread(()->{
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(endPath,"rw");
                    ;
                    randomAccessFile.skipBytes(skeptByte);
                    byte[] bytes = new byte[(int)readlength];
                    int readl;
                    readl= randomAccessFile.read(bytes);
                    System.out.println(Thread.currentThread().getName()+"------------------");
                    System.out.println(new String(bytes));
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file,"rw");

                    randomAccessFile2.skipBytes(skeptByte);
                    randomAccessFile2.write(bytes,0,readl);
                    randomAccessFile2.close();
                    randomAccessFile.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            },"线程:"+i+" ").start();
        }
    }
}

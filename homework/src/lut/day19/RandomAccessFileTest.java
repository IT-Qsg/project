package lut.day19;

import java.io.*;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        File sec = new File("E:\\笔记.txt");
        File endPath = new File("E:\\a.txt");
        RandomAccessFile rf  = new RandomAccessFile(sec,"rw");
        RandomAccessFile wr  = new RandomAccessFile(endPath,"rw");
        TestThreadAndRandomAccessFile t = new TestThreadAndRandomAccessFile(rf,wr);
        new Thread(t,"T1").start();
        new Thread(t,"T2").start();
        new Thread(t,"T3").start();
        new Thread(t,"T4").start();

    }
}
class TestThreadAndRandomAccessFile implements Runnable{
    RandomAccessFile rf  ;
    RandomAccessFile wf  ;
    public TestThreadAndRandomAccessFile(RandomAccessFile rf, RandomAccessFile wr) throws IOException {
        this.rf = rf;
        this.wf = wr;
    }

    @Override
    public void run() {
        while(true){
        synchronized (this){
            System.out.println(Thread.currentThread().getName());

            try {
               // String s = rf.readLine();
               // if(s==null)break;
                //wf.writeUTF(s);
               // Thread.sleep(1000);
                byte[] b = new byte[1024];
                int read = rf.read(b, 0, b.length);
                if(read==-1)break;
                wf.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
}

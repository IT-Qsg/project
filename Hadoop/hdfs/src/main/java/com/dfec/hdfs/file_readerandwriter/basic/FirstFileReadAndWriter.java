package com.dfec.hdfs.file_readerandwriter.basic;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;


/**
 * @author qsg
 * @version 1.0 v
 * @Classname FirstFileReadAndWriter
 * @Date 2020/7/23 9:05
 * @Copyright DFEC
 **/
public class FirstFileReadAndWriter {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
      //  conf.set("ds.defaultFS","hdfd://192.168.43.38:9000");
        FileSystem fs = null;
        try {
            //fileSystem可以创建任何子对象
            fs = FileSystem.get(URI.create(args[0]),conf);
//            fs.getClass().getName();
            //得到的是本地的org.apache.hadoop.hdfs.DistributedFileSystem
            System.out.println(fs.getClass().getName());
            FSDataInputStream inp = fs.open(new Path(args[1]));

            byte [] b = new byte[1024];
            int len ;
            while ((len = inp.read(b))!=-1){
                System.out.println(new String (b,0,len));
//                System.out.println("test output");
            }
            System.out.println(fs.open(new Path(args[1])).getClass().getName());
            inp.close();
            fs.close();

//            fs= FileSystem.get(URI.create("hdfs://192.168.43.38:9000"),conf);
//            fs1= FileSystem.get(URI.create("file:///etc/passwd"),conf);
//            System.out.println(fs1.getClass().getName());
//            Path path = new Path("hdfs://192.168.43.38:9000");
//            DistributedFileSystem

           /* FSDataInputStream inp = fs.open(new Path(args[1]));
            int len;
            byte[] bytes = new byte[1024];
            while((len=inp.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
            System.out.println(fs.getClass().getName());
            inp.close();
            fs.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
//        fs.open()
    }
}

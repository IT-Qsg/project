package com.dfec.hdfs.file_readerandwriter.basic;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.client.HdfsDataOutputStream;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.FileInputStream;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname UtilTestFile_RW
 * @Date 2020/7/23 13:09
 * @Copyright DFEC
 **/
public class UtilTestFile_RW extends Configured implements Tool {
    /*
     * 文件上传hdfs
     * @param strings
     * @return
     * @throws Exception*/

    @Override
    public int run(String[] strings) throws Exception {
        //获取配置信息
        Configuration conf = getConf();
        String input_path = conf.get("input_path");
        String output_path = conf.get("output_path");

        FileSystem fs = FileSystem.get(conf);

        //本地文件用本地文件对象进行读取
        FileInputStream finp = new FileInputStream(input_path);
        Path path = new Path(output_path);
        //若果路劲存在
       // if(fs.exists(path)){
        //返回的是org.apache.hadoop.hdfs.client.HdfsDataInputStream
            HdfsDataOutputStream out =(HdfsDataOutputStream)fs.create(path);
            byte[] b = new byte[1024];
            int len;
            while ((len = finp.read(b))!=-1){
                out.write(b,0,len);
                out.flush();
            }
            out.close();

        /*}else
            System.out.println("路径不存在");*/
        finp.close();
        fs.close();
        return 0;
    }

    public static void main(String[] args) {
        try {
            int result = ToolRunner.run(new UtilTestFile_RW(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*@Override
    public int run(String[] strings) throws Exception {
        //根据hadoop中封装好的类库获得配置信息
        Configuration conf = getConf();
        String putlfile = conf.get("local_file_path");
        String outfile = conf.get("hdfs_file_path");
        FileSystem fs = FileSystem.get(conf);
        System.out.println("分布式文件系统 =="+fs.getClass().getName());

        //注意：上传本地文件
        //1.读取本地文件
        //Path path = new Path(putlfile);
        //System.out.println("测试使用open()方法读取本地文件");
        //FSDataInputStream inp = fs.open(path);
        FileInputStream inp = new FileInputStream(putlfile);
        byte [] bytes = new byte[1024];
        int len;

        FSDataOutputStream out = fs.create(new Path(outfile));
        while((len = inp.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        System.out.println("上传完毕");
        out.flush();
        out.close();
        inp.close();
        fs.close();
        return 0;
    }

    public static void main(String[] args) {
        try {
            int result = ToolRunner.run(new UtilTestFile_RW(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

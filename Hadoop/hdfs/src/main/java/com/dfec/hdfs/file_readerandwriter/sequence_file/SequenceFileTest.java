package com.dfec.hdfs.file_readerandwriter.sequence_file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SequenceFileTest
 * @Date 2020/7/23 15:45
 * @Copyright DFEC
 **/
public class SequenceFileTest extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = getConf();
        String output_path = conf.get("output_path");
        //设置写的路径
        SequenceFile.Writer.Option seq = SequenceFile.Writer.file(new Path(output_path));
        //设置键值
        SequenceFile.Writer.Option key = SequenceFile.Writer.keyClass(IntWritable.class);
        SequenceFile.Writer.Option value = SequenceFile.Writer.valueClass(Text.class);

        //设置压缩格式  可比用管
        SequenceFile.Writer.Option comp = SequenceFile.Writer.compression(SequenceFile.CompressionType.RECORD, new BZip2Codec());

        SequenceFile.Writer wr = SequenceFile.createWriter(conf,seq,key,value,comp);
        //写100 键值
        for (int i = 1;i<101;i++){
            if(i%3==0)wr.sync();//设置同步标记
            wr.append(new IntWritable(i),new Text("测试seq_file:"+i));
        }
        wr.close();
        return 0;
    }

    public static void main(String[] args) {
        try {
            int result = ToolRunner.run(new SequenceFileTest(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

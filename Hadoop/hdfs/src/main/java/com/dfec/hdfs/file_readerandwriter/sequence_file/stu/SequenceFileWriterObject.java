package com.dfec.hdfs.file_readerandwriter.sequence_file.stu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SequenceFileWriterObject
 * @Date 2020/7/23 16:41
 * @Copyright DFEC
 **/
public class SequenceFileWriterObject extends Configured implements Tool {
    /**
     * 将对象写入hdfs 集群
     * @param strings
     * @return
     * @throws Exception
     */
    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = getConf();
        String savepath = conf.get("savepath");

        SequenceFile.Writer.Option swr = SequenceFile.Writer.file(new Path(savepath));
        SequenceFile.Writer.Option key = SequenceFile.Writer.keyClass(IntWritable.class);
        SequenceFile.Writer.Option value = SequenceFile.Writer.valueClass(Student.class);
        SequenceFile.Writer.Option comp = SequenceFile.Writer.compression(SequenceFile.CompressionType.RECORD,new BZip2Codec());

        SequenceFile.Writer sw = SequenceFile.createWriter(conf,swr,key,value,comp);
        for(int i=0;i<10;i++) {
            sw.append(new IntWritable(i),new Student((long)i,"name",20));
        }
        sw.close();
        return 0;
    }

    public static void main(String[] args) {
        try {
            int result = ToolRunner.run(new SequenceFileWriterObject(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

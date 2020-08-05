package com.dfec.hdfs.file_readerandwriter.sequence_file.stu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SequdenceFileReaderObject
 * @Date 2020/7/23 16:58
 * @Copyright DFEC
 **/
public class SequdenceFileReaderObject extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = getConf();
        String readpath = conf.get("readpath");

        SequenceFile.Reader.Option seq = SequenceFile.Reader.file(new Path(readpath));
        SequenceFile.Reader sr = new SequenceFile.Reader(conf,seq);

        IntWritable key =(IntWritable) sr.getKeyClass().newInstance();
        Student value =(Student) sr.getValueClass().newInstance();

        while (sr.next(key,value)){
            System.out.println("key:"+key+"------------->value:"+value);
        }
        sr.close();

        return 0;
    }

    public static void main(String[] args) {
        try {
            int result = ToolRunner.run(new SequdenceFileReaderObject(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

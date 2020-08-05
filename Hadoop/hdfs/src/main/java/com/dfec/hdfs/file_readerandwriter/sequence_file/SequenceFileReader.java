package com.dfec.hdfs.file_readerandwriter.sequence_file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SequenceFileReader
 * @Date 2020/7/23 16:06
 * @Copyright DFEC
 **/
public class SequenceFileReader extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {

        Configuration conf = getConf();
        String inputpath = conf.get("inputpath");

        SequenceFile.Reader.Option sro = SequenceFile.Reader.file(new Path(inputpath));
        SequenceFile.Reader sr = new SequenceFile.Reader(conf,sro);
        //设置键的类型
        IntWritable key =(IntWritable) sr.getKeyClass().newInstance();
        //设置值的类型
        Text value = (Text)sr.getValueClass().newInstance();
        //基于当前位置找到下一个同步标记
        sr.seek(sr.getPosition());
        while(sr.next(key,value)){
//             System.out.println(key+":"+value);
            //如果是同步标记
            if(sr.syncSeen()) {
                System.out.println("同步标记："+key+"---------->"+value);
                sr.seek(sr.getPosition());
            }

        };
        return 0;
    }

    public static void main(String[] args) {
        int result = 0;
        try {
            result = ToolRunner.run(new SequenceFileReader(), args);
            System.exit(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

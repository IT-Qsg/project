package com.dfec.flink.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname kafksProducer
 * @Date 2020/7/28 16:47
 * @Copyright DFEC
 **/
public class kafksProducer {
    private Producer<String,String> producer;

    public kafksProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.40.15:9092");
//        props.put("bootstrap.servers", "192.168.1.171:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<String, String>(props);
    }

    public void produceMessage(){

        Random random=new Random();
        for(int x=0;x<100;x++){
            String key=String.valueOf(random.nextInt(255));
            String value=String.valueOf(new Date().getTime());
            this.producer.send(new ProducerRecord("flink",value));
            System.out.println("Sent message: ("+key+", "+value+")");
        }
    }

    public static void main(String[] args) throws InterruptedException {
            new kafksProducer().produceMessage();
           /* Properties props = new Properties();
            props.put("bootstrap.servers", "192.168.1.171:9092");
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("linger.ms", 1);
            props.put("buffer.memory", 33554432);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            Producer<String, String> producer = new KafkaProducer<>(props);
            int totalMessageCount = 100;
            for (int i = 0; i < totalMessageCount; i++) {

                String value = String.format("%d,%s,%d", System.currentTimeMillis(), "machine-1", currentMemSize());
                System.out.println("开始生产消息：" + value);
                producer.send(new ProducerRecord<>("estest", value), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            System.out.println("Failed to send message with exception " + exception);
                        }
                    }
                });
                Thread.sleep(100L);
            }
            producer.close();*/
        }

      /* private static long currentMemSize() {
            return MemoryUsageExtrator.currentFreeMemorySizeInBytes();
        }*/
}

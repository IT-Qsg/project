package com.dfec.flink.kafka;


import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User:
 * \* Date: 2020/7/29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class KafkaProduceTest2 {
    private Producer<String, String> producer;


    public KafkaProduceTest2() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.40.15:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(props);

    }

    public void sendMessage() {
        int totalMessageCount = 100;
        for (int i = 0; i < totalMessageCount; i++) {
            String value = String.format("%d,%s,%d", System.currentTimeMillis(), "machine-1", 1231231312);
            System.out.println("111" + value);
            this.producer.send(new ProducerRecord<>("flink",value));
        }
        producer.close();
    }


    public static void main(String[] args) {
        new KafkaProduceTest2().sendMessage();
    }
}

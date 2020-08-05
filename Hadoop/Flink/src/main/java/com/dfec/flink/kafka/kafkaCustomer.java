package com.dfec.flink.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname kafkaCustomer
 * @Date 2020/7/28 17:41
 * @Copyright DFEC
 **/
public class kafkaCustomer {
    private String topic;
    private Consumer<String,String> consumer;

    public kafkaCustomer(String topic) throws IOException {
        this.topic=topic;
        Properties props=new Properties();
        props.put("bootstrap.servers", "192.168.40.15:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
       // key.deserializer=org.apache.kafka.common.serialization.StringDeserializer
     //   value.deserializer=org.apache.kafka.common.serialization.StringDeserializer

        //   properties.load(this.getClass().getResourceAsStream("/kafka.properties"));
        this.consumer=new KafkaConsumer<String,String>(props);
    }

    public void consumeMessage(){
        this.consumer.subscribe(Collections.singletonList(this.topic));
        while (true){
           this.consumer.poll(100)
//           this.consumer.poll(Duration.ofSeconds(1000))1
                    .forEach(System.out::println);
            System.out.println("**************");
        }
    }

    public static void main(String[] args) throws IOException{
        new kafkaCustomer("flink")
                .consumeMessage();
    }
}

package com.dfec.flink.kafka.unitl

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011

/**
  * @author qsg
  * @Classname FlinkKafka
  * @version 1.0 v
  * @Date 2020/7/29 11:40
  * @Copyright DFEC
  **/
object FlinkKafka {

  val prop = new Properties()

  prop.setProperty("bootstrap.servers","hadoop1:9092")
  prop.setProperty("group.id","gmall")

  def getConsumer(topic:String ):FlinkKafkaConsumer011[String]= {
    val myKafkaConsumer:FlinkKafkaConsumer011[String] = new FlinkKafkaConsumer011[String](topic, new SimpleStringSchema(), prop)
    myKafkaConsumer
  }

}

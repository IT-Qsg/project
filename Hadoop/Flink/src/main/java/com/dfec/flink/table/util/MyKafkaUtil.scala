package com.dfec.flink.table.util

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010

/**
  * @author qsg
  * @Classname MyKafkaUtil
  * @version 1.0 v
  * @Date 2020/7/31 8:42
  * @Copyright DFEC
  **/
object MyKafkaUtil {

  var pro = new Properties()
  val prop = new Properties()
  prop.setProperty("bootstrap.servers","192.168.1.171:9092")
  prop.setProperty("group.id", "consumer-group")
  prop.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  prop.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  prop.setProperty("auto.offset.reset", "latest")

  def getKafkaCustomer(topic:String):FlinkKafkaConsumer010[String]={
    val kc = new FlinkKafkaConsumer010[String](topic,new SimpleStringSchema(),pro);
    kc
  }

}

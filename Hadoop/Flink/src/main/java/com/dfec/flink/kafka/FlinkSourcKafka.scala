package com.dfec.flink.kafka

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
  * @author qsg
  * @Classname FlinkSourcKafka
  * @version 1.0 v
  * @Date 2020/7/29 8:47
  * @Copyright DFEC
  **/
object FlinkSourcKafka {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
   import com.dfec.flink.kafka.unitl.FlinkKafka
    import org.apache.flink.api.scala._
    val ds: DataStream[String] = env.addSource(FlinkKafka.getConsumer("estest"))
    ds.print()
    env.execute()
  }

}

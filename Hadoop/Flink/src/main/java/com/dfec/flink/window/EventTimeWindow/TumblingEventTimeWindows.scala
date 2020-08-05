package com.dfec.flink.window.EventTimeWindow

import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.datastream.{DataStream, KeyedStream, WindowedStream}
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow

import scala.collection.immutable.HashSet

/**
  * @author qsg
  * @Classname TumblingEventTimeWindows
  * @version 1.0 v
  * @Date 2020/7/30 16:32
  * @Copyright DFEC
  **/
object TumblingEventTimeWindows {
  def main(args: Array[String]): Unit = {
    //  环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    env.setParallelism(1)

    val ds: DataStream[String] = env.socketTextStream("192.168.1.174",7777)
    val twd: DataStream[(String, Long, Int)]= ds.map(new MapFunction[String,(String,Long,Int)] {
      override def map(t: String): (String, Long,Int) = {
        val str: Array[String] = t.split(" ")
        val tup = (str(0),str(1).toLong,1)
        tup
      }
    }).assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor[(String, Long, Int)](Time.milliseconds(1000)) {
      override def extractTimestamp(element: (String, Long, Int)): Long = {

        return  element._2
      }
    })

    var value =  twd.keyBy(0)
    value.print("textkey:")

    //val wtt: WindowedStream[(String, Long, Int), Tuple, TimeWindow] = value.window(org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows.of(Time.seconds(2)))

    env.execute()

  }

}

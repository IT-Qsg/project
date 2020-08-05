package com.dfec.flink.window.timewindow.scala

import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala.{DataStream, KeyedStream, StreamExecutionEnvironment, WindowedStream}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow

/**
  * @author qsg
  * @Classname SlidingEventTimeWindows
  * @version 1.0 v
  * @Date 2020/7/30 16:00
  * @Copyright DFEC
  **/
object SlidingEventTimeWindows extends App {

  //构建环境
  val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
  //获取数据源
  val ds: DataStream[String] = env.socketTextStream("192.168.1.174",7777)

  import org.apache.flink.api.scala.createTypeInformation
  val value: KeyedStream[(String, Int), Tuple] = ds.flatMap(_.split(" ")).map((_,1)).keyBy(0)

  //滑动窗口测试
  //每5秒生成一个窗口统计10秒内的数据
  val ws: WindowedStream[(String, Int), Tuple, TimeWindow] = value.timeWindow(Time.seconds(10),Time.seconds(5))
  //处理的数据仅仅只是该窗口中的数据
  ws.sum(1).print()

  ds.print()
  env.execute();
}

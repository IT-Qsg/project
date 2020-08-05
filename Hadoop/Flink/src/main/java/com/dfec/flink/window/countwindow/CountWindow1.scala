package com.dfec.flink.window.countwindow

import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala.{DataStream, KeyedStream, StreamExecutionEnvironment, WindowedStream}
import org.apache.flink.streaming.api.windowing.windows.{GlobalWindow, TimeWindow}

/**
  * @author qsg
  * @Classname CountWindow1
  * @version 1.0 v
  * @Date 2020/7/30 16:07
  * @Copyright DFEC
  **/
object CountWindow1 extends App {
  //构建环境
  val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
  //获取数据源
  val ds: DataStream[String] = env.socketTextStream("192.168.1.174",7777)

  import org.apache.flink.api.scala.createTypeInformation
  val value: KeyedStream[(String, Int), Tuple] = ds.flatMap(_.split(" ")).map((_,1)).keyBy(0)

  //相同key值达到 10 个是触发窗口执行
  val ws: WindowedStream[(String, Int), Tuple, GlobalWindow] = value.countWindow(10)
  //处理的数据仅仅只是该窗口中的数据， 数据不会累加
  ws.sum(1).print()

  ds.print()
  env.execute();

}

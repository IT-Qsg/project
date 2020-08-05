package com.dfec.flink.window.countwindow

import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala.{DataStream, KeyedStream, StreamExecutionEnvironment, WindowedStream}
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow

/**
  * @author qsg
  * @Classname CountWindow2
  * @version 1.0 v
  * @Date 2020/7/30 16:14
  * @Copyright DFEC
  **/
object CountWindow2 extends App{
 //构建环境
 val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
  //获取数据源
  val ds: DataStream[String] = env.socketTextStream("192.168.1.174",7777)

  import org.apache.flink.api.scala.createTypeInformation
  val value: KeyedStream[(String, Int), Tuple] = ds.flatMap(_.split(" ")).map((_,1)).keyBy(0)

  //// 每当某一个key的个数达到3的时候,触发计算，计算最近该key最近10个元素的内容
  val ws: WindowedStream[(String, Int), Tuple, GlobalWindow] = value.countWindow(10,2)
  //处理的数据仅仅只是该窗口中的数据， 数据不会累加
  ws.sum(1).print()

  ds.print()
  env.execute();

}

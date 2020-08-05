package com.dfec.flink.window.timewindow.scala

import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala.{DataStream, KeyedStream, StreamExecutionEnvironment, WindowedStream}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow

/**
  * @author qsg
  * @Classname TimeWindowScala
  * @version 1.0 v
  * @Date 2020/7/30 14:18
  * @Copyright DFEC
  **/
object TimeWindowScala {
  def main(args: Array[String]): Unit = {
    //构建环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    //获取数据源
    val ds: DataStream[String] = env.socketTextStream("192.168.1.174",7777)

    import org.apache.flink.api.scala.createTypeInformation
    val value: KeyedStream[(String, Int), Tuple] = ds.flatMap(_.split(" ")).map((_,1)).keyBy(0)

    //滚动窗口测试
    //每10秒生成一个滚动窗口
    val ws: WindowedStream[(String, Int), Tuple, TimeWindow] = value.timeWindow(Time.seconds(10))
    //处理的数据仅仅只是该窗口中的数据
    ws.sum(1).print()

    ds.print()
    env.execute();

  }

}

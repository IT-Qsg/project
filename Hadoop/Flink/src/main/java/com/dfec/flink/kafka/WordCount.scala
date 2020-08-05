package com.dfec.flink.kafka

import org.apache.flink.api.scala.{AggregateDataSet, DataSet, ExecutionEnvironment}

/**
  * @author qsg
  * @Classname WordCount
  * @version 1.0 v
  * @Date 2020/7/28 9:28
  * @Copyright DFEC
  **/

/*

* 批处理 进行单词统计
 */
object WordCount extends App {

  //构造环境
  val env:ExecutionEnvironment  =  ExecutionEnvironment.getExecutionEnvironment
  //读取文件
  val input:String="D:\\ideaIU\\project\\Hadoop\\Flink\\flink"
  val ds: DataSet[String] = env.readTextFile(input)
  // 其中flatMap 和Map 中  需要引入隐式转换
  //经过groupby进行分组，sum进行聚合
  import org.apache.flink.api.scala._
  val aggDs: AggregateDataSet[(String, Int)] =
    ds.flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)
      .sum(1)
  // 打印
  aggDs.print()

}

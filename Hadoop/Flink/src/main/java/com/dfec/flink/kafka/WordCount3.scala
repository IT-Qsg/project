package com.dfec.flink.kafka

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.api.scala.{AggregateDataSet, DataSet, ExecutionEnvironment}
import org.apache.flink.core.fs.FileSystem.WriteMode

/**
  * @author qsg
  * @Classname WordCount3
  * @version 1.0 v
  * @Date 2020/7/28 22:51
  * @Copyright DFEC
  **/
object WordCount3 {
  def main(args: Array[String]): Unit = {

  val tool:ParameterTool = ParameterTool.fromArgs(args)
  /*  val input:String = tool.get("input")
    print(input)
    val out:String = tool.get("out")
    print(out)*/
    val input="D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\resources\\source"
  //构建环境
  val env :ExecutionEnvironment =ExecutionEnvironment .getExecutionEnvironment
    //算子处理
    val ds: DataSet[String] = env.readTextFile(input)
    //引入隐式转换函数
    import org.apache.flink.api.scala.createTypeInformation
    val ad: AggregateDataSet[(String, Int)] = ds.flatMap(_.split(" ")).map((_,1)).groupBy(0).sum(1)

    ad.writeAsText("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\resources\\out",WriteMode.OVERWRITE)
      .setParallelism(1)//只输出到一个文件
    ad.print()
  //  env.execute()

  }

}

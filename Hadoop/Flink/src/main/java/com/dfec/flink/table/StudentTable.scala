package com.dfec.flink.table

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.{Table, TableEnvironment}
import org.apache.flink.table.api.scala.StreamTableEnvironment
import org.apache.flink.api.scala._

/**
  * @author qsg
  * @Classname StudentTable
  * @version 1.0 v
  * @Date 2020/7/31 11:56
  * @Copyright DFEC
  **/
object StudentTable extends App {
  val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
  val stuF: DataStream[String] = env.readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\stu")
  var v :DataStream[Student] = stuF.map(
    s=>{
      val arr: Array[String] = s.split(" ")
      val stu = new Student(arr(0).toInt,arr(1))
      stu
    })
  //构建表环境
  val tenv: StreamTableEnvironment = TableEnvironment.getTableEnvironment(env)
  //格式化数据(表与字段的对应)
  tenv.registerDataStream("student",v)
  val stb: Table = tenv.fromDataStream(v)
  val tb: Table = stb.select("id,name").filter("id=3")
  println(tb.tableName)
  //得到的数据加入表环境
  val sds: DataStream[Student] = tenv.toAppendStream[Student](tb)
  sds.print()
  //表的字段类型
  tb.printSchema()
  env.execute()

}

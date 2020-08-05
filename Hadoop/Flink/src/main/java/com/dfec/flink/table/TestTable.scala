package com.dfec.flink.table

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.{Table, TableEnvironment}
import org.apache.flink.table.api.scala.StreamTableEnvironment
import org.apache.flink.api.scala._

/**
  * @author qsg
  * @Classname TestTable
  * @version 1.0 v
  * @Date 2020/7/31 8:11
  * @Copyright DFEC
  **/
object TestTable {

  def main(args: Array[String]): Unit = {

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val stuF: DataStream[String] = env.readTextFile("D:\\ideaIU\\project\\Hadoop\\Flink\\src\\main\\java\\com\\dfec\\flink\\table\\stu")

   var v :DataStream[Student] = stuF.map(
      s=>{
        val arr: Array[String] = s.split(" ")
        val stu = new Student(arr(0).toInt,arr(1))
        stu
     //   println(stu.toString)
  //     val str:String = JSON.toJSONString(stu, SerializerFeature.UseSingleQuotes)

     //   val jo = JSON.parseObject(stu.toString)
     //  print(jo)
    })

    //获取数据源
   // val ds: DataStream[String] = env.addSource(MyKafkaUtil.getKafkaCustomer("estest"))
    //构建表环境
    val tenv: StreamTableEnvironment = TableEnvironment.getTableEnvironment(env)

    //val dss: DataStream[Student] = ds.map(str=>{JSON.parseObject(str,classOf[Student])})
    val stb: Table = tenv.fromDataStream(v)
    //    tenv.registerTable("student",null)
    //    val stb = tenv.scan("student")
        val tb: Table = stb.select("id,name").filter("id=3")//.select("id")
    val sds: DataStream[Student] = tenv.toAppendStream[Student](tb)
    sds.print()

    tb.printSchema()
   // val str: String = tb.toString()
   // println(str)
    env.execute()
  }

}

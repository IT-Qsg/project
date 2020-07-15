package sp_sc.day4

import java.sql.Timestamp

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.streaming.{OutputMode, StreamingQuery}
import org.junit.Test

/**
  * @author qsg
  * @Date 2019/12/5 16:23
  * @describe
  * @version 1.0
  **/
class neApi {
  //socket对接
  @Test
  def fun1()={
    import sp_sc.util.Init
    Init.init()
    Logger.getLogger("org").setLevel(Level.WARN)
//    SparkSession.builder().master("local[*]").appName("new1")
    val spark = getSpark("new")
    import spark.implicits._
    val df: Dataset[String] = spark.readStream
      .option("host","192.168.43.38")
      .option("port",9999)
//      .option("includeTimestamp",true)
      .format("socket")
      .load().as[String]
    val res: DataFrame = df.flatMap(_.split(" ")).groupBy("value").count()
    val sq = res.writeStream
      .outputMode(OutputMode.Complete())//输出模式
      .option("truncate",false)//不截断内容
      .format("console")
      .start()
    sq.awaitTermination()//等待数据到来
    sq.stop()
  }
  //kafka对接
  @Test
  def fun2()={
    import sp_sc.util.Init
    Init.init()
    Logger.getLogger("org").setLevel(Level.WARN)
    //    SparkSession.builder().master("local[*]").appName("new1")
    val spark = getSpark("new2")
    import spark.implicits._
    val df = spark.readStream
      .option("kafka.bootstrap.servers","192.168.43.38:9092")
      .option("subscribe","spark")
      //      .option("includeTimestamp",true)
      .format("kafka")
      .load()
    val res = df.selectExpr("CAST(value AS STRING)","timestamp")
   // val res: DataFrame = df.flatMap(_.split(" ")).groupBy("value").count()
    val sq = res.writeStream
      .outputMode(OutputMode.Append())//输出模式
      .option("truncate",false)//不截断内容
      .format("console")
      .start()
    sq.awaitTermination()//等待数据到来
    sq.stop()
  }
  //文件对接
  @Test
  def fun3()={
    import sp_sc.util.Init
    Init.init()
    Logger.getLogger("org").setLevel(Level.WARN)
    //    SparkSession.builder().master("local[*]").appName("new1")
    val spark = getSpark("new2")
    import spark.implicits._
    val df = spark.readStream
      .option("path","temp")
      //      .option("includeTimestamp",true)
      .format("text")
      .load().as[String]
    val sq = df.writeStream
      .outputMode(OutputMode.Append())//输出模式
      .option("truncate",false)//不截断内容
      .format("console")
      .start()
    sq.awaitTermination()//等待数据到来
    sq.stop()
  }

  //窗口函数【滑动窗口】
  @Test
  def fun4()={
    import sp_sc.util.Init
    Init.init()
    Logger.getLogger("org").setLevel(Level.WARN)
    //    SparkSession.builder().master("local[*]").appName("new1")
    val spark = getSpark("窗口函数")
    import spark.implicits._
    val df: Dataset[(String, Timestamp)] = spark.readStream
      .option("host","192.168.43.38")
      .option("port",9999)
      .option("includeTimestamp",true)//每条数据还要显示时间戳
      .format("socket")
      .load().as[(String,Timestamp)]
    import org.apache.spark.sql.functions._
    val res: DataFrame = df.flatMap{case (value,time)=>{
      val vs = value.split(" ")
      vs.map(v=>(v,time))
    }}.toDF("value","timestamp")
      .groupBy(window($"timestamp","10 seconds"),$"value")
      .count()
    val sq: StreamingQuery = res.writeStream
      .outputMode(OutputMode.Complete())//输出模式
      .option("truncate",false)//不截断内容
      .format("console")
      .start()
    sq.awaitTermination()//等待数据到来
    sq.stop()
  }

}

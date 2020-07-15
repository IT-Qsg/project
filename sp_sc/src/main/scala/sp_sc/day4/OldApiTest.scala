package sp_sc.day4

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Duration, StreamingContext}

/**
  * @author qsg
  * @Date 2019/12/5 16:04
  * @describe 老的api操作
  * @version 1.0
  **/
object OldApiTest {
  def main(args: Array[String]): Unit = {
    //nc -lk 9999
    Logger.getLogger("org").setLevel(Level.WARN)
    val conf = new SparkConf().setMaster("local[3]").setAppName("ild")
    val ssc = new StreamingContext(conf,Duration(1000))

    val ds: ReceiverInputDStream[String] =
      ssc.socketTextStream("192.168.43.38",9999)
//    DStream  ==>RDD
    val res: DStream[(String, Long)] = ds.flatMap(_.split(" ")).countByValue()
    res.print()

    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}

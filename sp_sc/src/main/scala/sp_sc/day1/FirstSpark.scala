package sp_sc.day1

import sp_sc.util.Init

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author qsg
  * @Date 2019/12/3 11:25
  * @describe
  * @version 1.0
  **/
object FirstSpark {
  def main(args: Array[String]): Unit = {
    //运行环境初始化【附加】
    Init.init()
    //1.spark conf
    var conf = new SparkConf()
    //获得几个线程处理
    conf.setMaster("local[*]")
    conf.setAppName("FirstSpark")
    //2.SparkContest
    //上下文，数据搬运
    var sc = new SparkContext(conf)
    //3. RDD 代表数据集
    //RDD类似ArrayBuffer 每个数据集代表一行
    //RDD是一个只读不可变的
    var rdd: RDD[String] = sc.textFile("hdfs://172.16.0.4:9000/ihaveadream.txt")
    //4.函数式操作
//    var s: RDD[Array[String]] = rdd.map(_.split(" "))
    var res: RDD[(String, Int)] = rdd.flatMap(_.split(" "))
            .groupBy(x=>x)
            .mapValues(ite=>ite.size)
//    var map: collection.Map[String, Int] = res.collectAsMap()
    res.foreach(println(_))
    res.foreachPartition(
      //几分区几个迭代器【抽象的】
      (iter:Iterator[(String,Int)]) =>{
        //[jdbc代码]
        //对分区中的数据进行循环
        iter.foreach(x=>{
          //数据操作
        })

    })
//    res.persist()
//    println(res)
    //5.保存结果
    //6.关闭资源
    sc.stop()
  }
}

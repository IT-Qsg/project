package sp_sc.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author qsg
  * @Date 2019/12/3 13:03
  * @describe
  * @version 1.0
  **/
class RDDTest {
  def createRdd()={
    var conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("FirstSpark")
    var sc = new SparkContext(conf)
    sc.textFile("")
    sc.wholeTextFiles("")
    sc.newAPIHadoopFile("")
    sc.parallelize(List())

  }
}

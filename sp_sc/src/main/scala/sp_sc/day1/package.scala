package sp_sc

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author qsg
  * @Date 2019/12/3 13:37
  * @describe
  * @version 1.0
  **/
package object day1 {
  def getSC(name:String,master:String="local[*]"):SparkContext={
    var conf = new SparkConf().setMaster(master).setAppName(name)
    new SparkContext(conf)
  }
}

package sp_sc

import org.apache.spark.sql.SparkSession

/**
  * @author qsg
  * @Date 2019/12/3 17:12
  * @describe
  * @version 1.0
  **/
package object day2 {
  def getSpark(name:String,master:String="local[*]")={
    var spark = SparkSession.builder().appName(name).master(master).getOrCreate()
    spark
  }
}

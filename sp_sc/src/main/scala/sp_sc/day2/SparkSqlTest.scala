package sp_sc.day2

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.junit.Test

/**
  * @author qsg
  * @Date 2019/12/3 17:15
  * @describe
  * @version 1.0
  **/
case class Student(var id:Int,var name:String,var clazz:Int,var gender:String,var age:Int)
case class Score(var id :Int,var subject:String,var v :Int)

class SparkSqlTest {
  /*def init()={
    import sp_sc.util.Init
    Init.init()
  }*/
  @Test
  def create1()={
    import sp_sc.util.Init
    Init.init()
    val spark = getSpark("firstSql")
    var sc = spark.sparkContext
    var rdd: RDD[(String, String)] = sc.textFile("topic/topicInfo")
        .map(line=>(line.split(",")(0),line.split(",")(1)))
    //RDD中放的是样例类，或元组 泛型为Product[createDataFrame[A <: Product : TypeTag]]
    var df = spark.createDataFrame(rdd)
    var v= df.createTempView("hello")
    var sh = spark.sql("select _2 title from hello").show()
    df.show()
    spark.close()
    sc.stop()
  }

    @Test
    def create2(){
      import sp_sc.util.Init
      Init.init()
      val spark = getSpark("firstSql")
      var sc = spark.sparkContext
//      val v: RDD[Int] = sc.parallelize(Seq(1,2,3,5),2)
//      v.foreach(println(_))
      val per: RDD[Persion] = sc.parallelize(Seq(
            Persion("lisi",20),
            Persion("zhangsan",22),
            Persion("wang",18),
            Persion("hui",12)
      ))
      val df: DataFrame = spark.createDataFrame(per)
      df.createTempView("persion")
      spark.sql("select name,age from persion where age > 20").show()
  }
  @Test
  def create3()={
    /*implicitly def test()={

    };*/
    import sp_sc.util.Init
    Init.init()
    val spark: SparkSession = getSpark("getSet")
    import spark.implicits._
    var sc = spark.sparkContext
    val rdd: RDD[Persion] = sc.parallelize(Seq(
      Persion("lisi",20),
      Persion("zhangsan",22),
      Persion("wang",18),
      Persion("hui",12)
    ))
    val ds: Dataset[Persion] = spark.createDataset(rdd)
  }

  @Test
  def create4()={
    import sp_sc.util.Init
    Init.init()
    val spark: SparkSession = getSpark("getSet")
    import spark.implicits._
    var sc = spark.sparkContext
    val rdd: RDD[Persion] = sc.parallelize(Seq(
      Persion("lisi",20),
      Persion("zhangsan",22),
      Persion("wang",18),
      Persion("hui",12)
    ))
    val ds: Dataset[Persion] = rdd.toDS()
    val df: DataFrame = rdd.toDF()


    val ds1: Dataset[Persion] = df.as[Persion]
    val df1: DataFrame = ds.toDF()
  }
  @Test
  def option()={
    Logger.getLogger("org").setLevel(Level.WARN)

    import sp_sc.util.Init
    import org.apache.spark.sql.functions.col
    Init.init()
    val spark: SparkSession = getSpark("getSet")
    import spark.implicits._
    var sc = spark.sparkContext
    var ds: Dataset[Student] = sc.parallelize(Seq(
      Student(1,"lisi",1,"M",21),
      Student(2,"zhengshan",2,"M",24),
      Student(3,"wnag",2,"F",22),
      Student(4,"tom",1,"M",18),
      Student(5,"jear",1,"F",19),
      Student(6,"kack",2,"F",20)
    )).toDS()
    ds.select("name","id","age").show()
    ds.select($"name",$"age"+10,$"id").show()
    ds.selectExpr("name","id","age+10 as AGE").show()
    ds.select(col("name"),col("id"),col("age")+10).show()


    ds.where("age > 20").show()
    ds.where($"age">20).show()
    ds.where("name in ('tom','jake')").show()

    println("=======================================")
    var map=Map("age"->"avg")
    ds.groupBy("clazz").agg("age"->"max","age"->"avg").show()
//    ds.filter()

//    ds.groupBy("clazz").pivot("gender").agg("gender"->"count").show()
    ds.groupBy("clazz").pivot("gender").count().show()
    ds.orderBy($"age" desc).show()

    val scs = sc.parallelize(Seq(
      Score(2,"java",5),
      Score(4,"c#",4),
      Score(3,"c",5),
      Score(6,"python",4)
    )).toDS()
    println("============join==============")
    ds.join(scs,ds("id")===scs("id"),"left").show()


    //===============
    //自定义函数，必须要返回值
    val seq = Seq("y","k")
    val f:String=>Boolean=s=>seq.contains(s.last+"")
    spark.udf.register("yk",f)
    ds.selectExpr("name","age").where("yk(name)").show()

    ds.createOrReplaceTempView("Student")

    spark.sql("select * from Student").show()
    ds.createGlobalTempView("student")
    spark.sql("select * from global_temp.student").show()
  }



}
object test{
  def main(args: Array[String]): Unit = {
    val v: String => Boolean = (x:String)=>x.contains("k")

    v("")
  }
}
package sp_sc.day3

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.junit.Test

/**
  * @author qsg
  * @Date 2019/12/4 16:07
  * @describe
  * @version 1.0
  **/

/*
分析任务：
1、130年中每年出生婴儿的男女比例
2、出生婴儿男女比例最失调的N个年份
3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
4、按性别计算每年最常用的1000个名字人数占当年总出生人数的比例（名字多样化分析）
5、按性别假定每年有频率最高的前N个名字(N最小)的婴儿人数总和超过当年该性别总人数的50%，N值随年份的变化趋势。（名字多样化分析）
6、各年出生的男孩名字以d/n/y结尾的人数占当年的比例
7、130年中，变化趋势最明显的前n个名字(可以考虑使用标准差度量)
 */
case class BabyInfo(var year:String,var name:String,var gender:String,var number:Int)
class BabyTest {
  import sp_sc.util.Init
  Init.init()
  val spark = SparkSession.builder().appName("Baby").master("local[*]").getOrCreate()
  @transient
  var sc = spark.sparkContext
  import spark.implicits._
  val babys: Dataset[BabyInfo] = sc.wholeTextFiles("baby/yob*").flatMap{
    case (path,cnt)=>{
      val year = path.substring(path.lastIndexOf("/")).substring(4,8);
      cnt.split("\n").map(line=>{
        val Array(name,gender,number)=line.trim.split(",")
        BabyInfo(year,name,gender,number.trim.toInt)
      })
    }
  }.toDS()
  //130年中每年出生婴儿的男女比例
  @Test
  def fun1(): Unit ={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.groupBy("year")
      .pivot("gender")
      .sum("number")
      .selectExpr("year","M/F")//.show()
      .createOrReplaceTempView("babyinfo")
    spark.sql("select * from babyinfo").show()

  }
  //2、出生婴儿男女比例最失调的N个年份
  @Test
  def fun2()={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.groupBy("year")
      .pivot("gender")
      .sum("number")
      .selectExpr("year","M/F as ratio")//.show()
      .createOrReplaceTempView("babyinfo")
    spark.sql("select year,(1-ratio) from babyinfo").show()
  }
  //3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
  @Test
  def fun3()={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.where("name in('John','Harry','Mary','Marilyn')")
      .groupBy("year","name")
      .sum("number").createOrReplaceTempView("babyinfo")
    spark.sql("select * from babyinfo").show()
    spark.read
  }
  //4、按性别计算每年最常用的1000个名字人数
  // 占当年总出生人数的比例（名字多样化分析）
  @Test
  def fun4()={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.createOrReplaceTempView("babyinfo")
    //总人数
    spark.sql("select year,sum(number) sum from babyinfo group by year").createOrReplaceTempView("t1")
    spark.sql("select year,gender,name,number, row_number() over(partition by year,gender order by number) row from babyinfo").createOrReplaceTempView("t2")
    spark.sql("select * from t2 where row < 1001").createOrReplaceTempView("t3")
    spark.sql("select year,gender,sum(number) sum1000 from t3 group by year,gender").createOrReplaceTempView("t4")
    spark.sql("select a.year,b.gender,(b.sum1000/a.sum) pr from t1 a left join t4 b on a.year=b.year").show()
  }
//  5、按性别假定每年有频率最高的前N个名字(N最小)的婴儿人数总和超过当年该性别总人数的50%，
//  N值随年份的变化趋势。（名字多样化分析）
  @Test
  def fun5()={
  Logger.getLogger("org").setLevel(Level.WARN)
  babys.createOrReplaceTempView("babyinfo");
//  spark.sql("select year,gender,name,sum(number) sum from babyinfo group by year,gender")
  spark.sql("select *,row_number() over(partition by year,gender order by number desc) row,sum(number) over(partition by year,gender order by number desc) sum1,sum(number) over(partition by year,gender) sum2 from babyinfo").createOrReplaceTempView("t1")
  //获得刚大于0.5的结果值
  spark.sql("select *,sum1/sum2 ratio from t1 where sum1/sum2>=0.5 order by ratio").createOrReplaceTempView("t2")
  spark.sql("select *,row_number() over(partition by year,gender order by number desc) top from t2").createOrReplaceTempView("t3")
  spark.sql("select * from t3 where top = 1").show()
}

//  6、各年出生的男孩名字以d/n/y结尾的人数占当年的比例
  @Test
  def fun6()={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.createOrReplaceTempView("babyinfo")
    spark.sql("select year,sum(number) sum from babyinfo group by year").createOrReplaceTempView("t2")
    spark.sql("select year,gender,substring(name,length(name),1) name,sum(number) sum1 from babyinfo where substring(name,length(name),1) in('d','y','n') and gender ='M' group by year,gender,substring(name,length(name),1)").createOrReplaceTempView("t1")
    spark.sql("select a.year,a.gender,a.name,a.sum1/b.sum from t1 a left join t2 b on a.year=b.year").show()
  }
//  7、130年中，变化趋势最明显的前n个名字(可以考虑使用标准差度量)
  @Test
  def fun7()={
    Logger.getLogger("org").setLevel(Level.WARN)
    babys.createOrReplaceTempView("babyinfo")
    spark.sql("select std(number) st from babyinfo").show()
//    babys.selectExpr("year,name,sum(number) sum1")
//      .groupBy("year","name")
  }
}

package sp_sc.day1
import org.apache.spark.rdd.RDD
import org.junit.Test

/**
  * @author qsg
  * @Date 2019/12/3 13:27
  * @describe
  * @version 1.0
  **/
object day1 {
}
class movieTest{
  @Test
  def first(): Unit ={
    var sc =getSC("first")
    var lines: RDD[String] = sc.textFile("file://D:\\ideaIU\\project\\sp_sc\\ml-1m\\users.dat")
      var users = lines.map(line=>line.split("::")(1))
      .groupBy(x=>x).mapValues(ite=>ite.size)

    //取值

    val m_users = users.collectAsMap()
    val f_v:Int = m_users("F")
    val m_v:Int = m_users("M")
    val cd = getCD(f_v,m_v)
    println("男女比例："+f_v/cd+":"+m_v/cd)


    //存在闭包问题【序列化】
   /* users.foreach(t=>{
      //存入数据库
    })
    //LOokup
    val f_v2 = users.lookup("F")
    val m_v2 = users.lookup("M")

    //循环过多
    var user2: RDD[(String, Int)] =
      lines.map(line=>(line.split("::")(1),1))
      .reduceByKey(_+_)

    //返回客户端在做
    var user3 = lines.map(line=>line.split("::")(1))
      .countByValue()*/
  }
  def getCD(x:Long,y:Long):Long={
    var z = x%y
    if(z==0){
      y
    }else{
      getCD(y,z)
    }
  }

  @Test
  def second()={
    import sp_sc.util.Init
    Init.init()
    //空行个数
    var sc = getSC("second")
    var rdd: RDD[String] = sc.textFile("ml-1m/README")
    //闭包现象
    var black =sc.longAccumulator("空行");
    //var blank=0;
    var res: RDD[(String, Int)] = rdd.flatMap(
      line=>{
        if(line==""){
//          blank=blank+1
          black.add(1)
        }
        line.split(" ")
      }).groupBy(x=>x).mapValues(ite=>ite.size)
    println(black.value)
    res.foreach(println(_))
  }
  //保存
  @Test
  def save():Unit={
    import sp_sc.util.Init
    Init.init()
    var sc =getSC("save")
    var lines: RDD[String] = sc.textFile("ml-1m/users.dat")
    var users: RDD[(String, Int)] = lines.map(line=>line.split("::")(1))
      .groupBy(x=>x).mapValues(ite=>ite.size)
    users.foreach(println(_))
//       users.saveAsTextFile("move_res")
//    users.saveAsHadoopFile("")
    sc.stop()
  }

  //电影前十评分
  @Test
  def third:Unit={
    import  sp_sc.util.Init
    Init.init()
    var sc =getSC("movie")
    var rdd: RDD[(String, Double)] =
      sc.textFile("ml-1m/ratings.dat")
        .map(line => {
          var Array(_, userid, score, _) = line.split("::")
          (userid, score.toDouble)
        })
    var r= rdd.groupByKey().mapValues(ite=>{
      ite.sum/ite.size
    }).map{
      case (x,y)=>(y,x)
    }.sortByKey(false)
      .top(10)
    //方式二
/*
      参数 1 第一遇见RDD函数中的key值时values执行的函数
      参数 2 第二次以后遇见RDD中的某个key值,values执行的函数
      参数 3 将第一个函数与第二个函数执行的结果进行【分区】聚合
 */
    var avg: Array[(Double, String)] = rdd.combineByKey((s:Double)=>(s,1), (e:(Double,Int),s:Double)=>(e._1+s,e._2+1), (e1:(Double,Int),e2:(Double,Int))=>(e1._1+e2._1,e1._2+e2._2))
        .mapValues(e=>e._1/e._2).map{
      case (x,y)=>(y,x)
    }.sortByKey(false)
      .top(10)
    avg.foreach(println(_))
//    r.foreach(println(_))
    rdd.aggregate(1)((e1, e2)=>e2._2.toInt+e1,(e1,e2)=>e1+e2)
    sc.stop()
  }
  @Test
  def pageTank(): Unit ={
    import sp_sc.util.Init
    Init.init()
    var sc = getSC("pageRank")
    val pordd: RDD[(String, Iterable[String])] = sc.textFile("pageRank/graphx-wiki-edges.txt")
      .map(line=>{
        val Array(page,ol)=line.split("\t")
        (page,ol)
      }).groupByKey()
    var prrdd: RDD[(String, Double)] = sc.textFile("pageRank/graphx-wiki-vertices.txt")
      .map(line=>{
        val Array(page,ol)=line.split("\t")
        (page,1.toDouble)
      })

     1 to 20 foreach(e=>{prrdd = prrdd.join(pordd).flatMap{
      case (page,(rank,ols))=>{
        val size = ols.size
        ols.map(ol=>{
          (ol,rank/size)
        })
    }}.groupByKey().mapValues(ite=>ite.sum)})
    prrdd.map(e=>{(e._2,e._1)}).sortByKey(false).top(10).foreach(println(_))
//    Thread.sleep(100000000000L)
  sc.stop()
  }
}

package com.lut.scala.Day5

import scala.collection.mutable

/**
  * @author qsg
  * @Date 2019/12/2 10:14
  * @describe
  * @version 1.0
  **/
object SetTest {
  def main(args: Array[String]): Unit = {
//    var set = Set(1,2,3,4,5)
//    var s = set.+(6)
//    println(s)
    implicit var or = new Ordering[Int]{
  override def compare(x: Int, y: Int): Int = {
    x-y
  }
}
    var set = mutable.TreeSet(33,34,12)

    println(set)
  }
}
object EnumText{
  def main(args: Array[String]): Unit = {
    var s = new Enumeration() {
      val s1="星期一"
      val s2="星期二"
      val s3="星期三"
    }
     var sum:Option[(String,String,String,Int)]=Some("test","jake","lili",20)
    println(s.s1)
  }
}
object listTest{

  def main(args: Array[String]): Unit = {
    var m:PartialFunction[Int,Int]={
      case x=>x*2
    }

    var list=List(12,13,45,12,12,78,65)

//    var s: Seq[Int] = list.collect(m)
//    var s: Seq[Int] = list.collect({case x =>x*2})
//    println(s)
//    var l = list.drop(2)
//    var l = list.dropWhile(_<20)
//    var l = list.filter {
//      _ % 2 == 0
//    }
//    list.flatMap(x=>)
//    println(l)
//    var l: Option[Int] = list.find(_%2!=0)
//    println(l)
//    var ss = list.foldLeft(0)((x,y)=>{x+y})
//    var ss = list.foldLeft(0)(_+_)
//    println(ss)
//    var v= list.head
//    println(v)
//    var v2 = list.headOption
//    println(v2)

//    var v= list.init(3)
//    println(v)
//    var lis = list.reduce((x,y)=>x+y)
    /*var lis = list.reduce((x,y)=>{
                 println(x+"-------------"+y)
                x+y
            })
      println(lis)*/
//   var l1= list.reduceLeft((x,y)=>{
//      println(x+"------"+y)
//      x+y
//    })
//    println(l1)
//    var l: Int = list.reduceRight((x, y)=>{
//      println(x+"------"+y)
//      x+y
//    })
//    println(l)
//    var l = list.slice(0,2)
//    var l = list.take(5)
//    println(l)
//    var l = list.distinct
//    println(l)
//    var l = list.map(_+2)
//    var l = list.flatMap(x=>List(x))
//    println(l)
    var l = list.groupBy(n=>n%2)
    println(l)
  }
}
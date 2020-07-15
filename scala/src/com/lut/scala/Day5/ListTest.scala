package com.lut.scala.Day5
import scala.collection.mutable.Map

/**
  * @author qsg
  * @Date 2019/11/29 14:24
  * @describe
  * @version 1.0
  **/
object ListTest {
  def main(args: Array[String]): Unit = {
//    var list=List
//    var nulllist=Nil
    var list: Seq[Int]=List(11,2,3,4,5,6)
    var list1=List(1,2,3,4,5,6)
    println(sum(list1))
//    var list2 = list.apply(2)
//    var v1 = list.last
//    var head = list.head
//    println(v1)
//    var v2 = list.tail
//    println(v2)
//    println("------------")
//    var vs = list.scan(0)((x,y)=>x+y)
//    println(vs)
  }
  def sum(list:List[Int]): Int ={
    if(list==Nil) 0 else list.head + sum(list.tail)
  }
  def sum1(list:List[Int]):Int= list match{
      case Nil => 0
      case h :: t => h+sum(t)
  }

}

object mapTest{
  def main(args: Array[String]): Unit = {
    var m = Map.apply("key"->"value","key2"->"value2")
    var v = m.apply("key")
    println(v)
  }
}


package com.lut.scala.Day4

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

/**
  * @author qsg
  * @Date 2019/11/28 15:12
  * @describe
  * @version 1.0
  **/
class ArrayTest {
}
object ArrayTest{
  def main(args: Array[String]): Unit = {
    //数组的创建
    /*
    长度不可变，类型一致
    * */
   /* var arr = new Array[Int](4)
    arr(0)=11
    arr(1)=12
    arr(2)=13
    arr(3)=14
    arr.foreach(println(_))

    var arr1 =Array(1,5,6,4,6,4,56,4,5,46,4,545,5)
    arr1.foreach(println(_))*/

//    var arr2 = Array.range(0,20)
//    var arr2 = Array.range(0,20,2)
//    arr2.foreach(println(_))

//    var arr =Array.empty[Int]
//    arr.foreach(println(_))
//      var arr1 =Array(2,6,8,30,1,5,6,4,6,4,56,4,5,46,4,545,5)
//    println(arr1(1))
//    println(arr1.apply(8))
//    var v = arr1.take(3)
//      var v = arr1.takeWhile(x=>x%2==0)
//      var v1 = arr1.takeWhile(_%2==0)
//    v.foreach(println(_))
//    var arr = new ArrayBuffer[String](){"test";"tt";"df"}
//    var s :String = arr.+("1111")
//    var arr = ArrayBuffer("test","tt","df")
//    arr.+=:("yuyendjskfjdkala;irijdkdkjgiei")
//    arr.:+=("hdhdh")
//    arr :+= "hdhdh"
//    arr.-=("tt")
//    implicit var mm = new Ordering[String]{
//      override def compare(x: String, y: String): Int = {
//        return -x.compareTo(y)
//      }
//    }
//    var ss = arr.sorted.reverse
//    var ss = arr.sorted(mm)
//    println(ss)
//    ss.sortBy()
//    arr.foreach(println(_))
//    var arr = Array.apply(1,2,3,4,5,6,7,8,9)
//    arr.foreach(println(_))
//    var arr = Array.range(0,20,3)
//    arr.foreach(println(_))
    var arr1 = ArrayBuffer("test","test2","test3")
    var arr2 = ArrayBuffer("briup","hdfs","dfs")
//    var arr = (arr1++arr2).sorted
//    println(arr)
    var arr = arr1.+:("111")
    println(arr)
  }
}

object TuppleTest{
  def main(args: Array[String]): Unit = {
    var t1 =Tuple1[String]("jsfkjhdskfhsdkaf")
    var t2 =new Tuple2[Int,String](225,"ludsnenksdn")
    var tn = (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    println(tn._2)
  }
}
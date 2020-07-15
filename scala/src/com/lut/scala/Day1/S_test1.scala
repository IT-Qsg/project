package com.lut.scala.Day1

/**
  * @author qsg
  * @Date 2019/11/25 16:39
  * @describe
  * @version 1.0
  **/
object S_test1 {
  def main(args: Array[String]): Unit = {
   // println("dfs")
   // show("啊哈",9)
    show

    var v = ve(20)
    println(v)
    println(ve(5))
  }

 /* def show(name:String,age:Int):Unit={
    println(name+"_"+age)
  }*/
  def show=println("123");

  var ve = (s:Int)=>s+2

}

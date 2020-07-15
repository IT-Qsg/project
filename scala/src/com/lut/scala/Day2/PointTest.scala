package com.lut.scala.Day2

/**
  * @author qsg
  * @Date 2019/11/26 14:34
  * @describe
  * @version 1.0
  **/
object PointTest {
  def main(args: Array[String]): Unit = {
    var point1 = new Point(12,33)
    var point2 = new Point(12,33)
    var point3 = new Point(65,32)
    println(point1==point2)
    println(point1==point3)
    println(point2==point3)

    println(PointObj.say(12,"test"))
    PointObj.show("lisi")

    println(PointObj show "隐式转换")
    println("------------------------------")
    new Person {
      override var name: String =_

      override def say(name: String): Unit = ???
    }
  }

}

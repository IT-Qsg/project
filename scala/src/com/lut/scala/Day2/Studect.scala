package com.lut.scala.Day2



/**
  * @author qsg
  * @Date 2019/11/26 15:21
  * @describe
  * @version 1.0
  **/
class Studect extends Person {
  override var name: String = "lisi"

  override def say(name: String): Unit = println(this.name)

   def apply: Studect = new Studect()
}
object  Studect{
  def main(args: Array[String]): Unit = {
    var v =new Studect
    var a = v.say("hhhhhhhhh");
    println(a)
  }
}
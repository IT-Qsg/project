package com.lut.scala.Day2

/**
  * @author qsg
  * @Date 2019/11/26 15:17
  * @describe
  * @version 1.0
  **/
trait Person {

  var name:String
  var age:Int=33
  def say(name:String)
  def hello=println("test_Trait")

}

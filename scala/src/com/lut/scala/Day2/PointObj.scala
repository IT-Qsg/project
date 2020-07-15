package com.lut.scala.Day2

/**
  * @author qsg
  * @Date 2019/11/26 14:47
  * @describe object中的属性方法都是静态的
  * @version 1.0
  **/
object PointObj {
  var name:String="test---"
  def say(a:Int,b:String)=a+"-"+b

  def show(name:String):String=name

}

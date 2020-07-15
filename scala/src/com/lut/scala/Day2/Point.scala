package com.lut.scala.Day2

/**
  * @author qsg
  * @Date 2019/11/26 14:34
  * @describe
  * @version 1.0
  **/
case class Point(x:Int,y:Int) {
//  override def equals(obj: Any): Boolean = true
def apply(x: Int, y: Int): Point = new Point(x, y)
}

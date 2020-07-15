package com.lut.scala.Day4

import scala.io.Source

/**
  * @author qsg
  * @Date 2019/11/28 15:02
  * @describe
  * @version 1.0
  **/
class ModelTest {
}
object ModelTest extends App{
  var list : List[String] = Source.fromFile("src/testfile").getLines().toList
  list.foreach(println(_))
}

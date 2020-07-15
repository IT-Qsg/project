package com.lut.scala.Day4

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * @author qsg
  * @Date 2019/11/29 9:55
  * @describe
  * @version 1.0
  **/
class ExceptionTest {
  def show(s:String):Unit = {
    try {
      if (s == "") throw new NullPointerException("空指针异常")
    }catch {
      case e1:NullPointerException =>e1.printStackTrace()
    }finally {
    println(s)
    }
  }
  @throws(classOf[Exception])
  def readFromFileOption(file:String):Option[List[String]]={
    try{
      Some(Source.fromFile(file).getLines().toList)
    }catch {
      case e:Exception => None
    }
  }
  def readFile(file:String):Try[List[String]]={
    Try(Source.fromFile(file).getLines().toList)
  }


}
object ExceptionTest{
  def main(args: Array[String]): Unit = {
//    new ExceptionTest().show("123")
//    var s = new ExceptionTest().readFromFileOption("src/testfile")
//    println(s)
    var s = new ExceptionTest().readFile("src/testfile")
    if(s.isSuccess){
      println("成功")
    }
    s match {
      case n:Success[List[_]]=>n.foreach(println(_))
      case m:Failure[List[_]]=>println("文件未找到")
    }
  }

}


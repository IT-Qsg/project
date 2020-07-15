package com.lut.scala.Day3

import java.io.FileInputStream

/**
  * @author qsg
  * @Date 2019/11/27 15:41
  * @describe
  * @version 1.0
  **/
class Student(name:String) {
  def show():String = name

  def go(name:String)=println(name)
}
object Student{
  def apply(name: String): Student = new Student(name)

  def main(args: Array[String]): Unit = {
//    implicit def test(name:Int)=name+""
//    implicit def test2(name:String)=111
    var s = Student("test")
    println(s.show())
//    s.go("lisi")
//    s.go(123)
  }
}
//object a {
////  implicit def int_to_sTRING(age:Int):String={age+""}
//  //implicit def sTring_to_int(tt:String):Int={tt}
//  def sum (num:Float)(implicit rate:Float)=num+rate
//  implicit var test = 1.05F
//  var v = sum(10.5F)(1.35F)
//  println(v)
//
//  def main(args: Array[String]): Unit = {
//
//  }
//}
object b{
  def main(args: Array[String]): Unit = {
    var a:Int=5
    var vw = a.toString
    println(vw)
    var t:String="111"
    var vv = t.toInt
    println(vv)

    val list: List[Any] = List(
      "a string",
      732,  // an integer
      'c',  // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    list.foreach(element => println(element))
  }
}
object valTest{
  def error(msg:String):Nothing={
    throw new RuntimeException(msg
    )
  }
  def deicde(x:Int,y:Int): Int ={
    if(y!=0)
      x/y
    else error("分母不能为零")
  }
  def main(args: Array[String]): Unit = {
    var x:Long=155498;
    var y:Float=x;
    val face: Char = '☺'
    val number: Int = face  // 9786
    println(number)
    var z:Char=x.toChar
    println(z)
    var vn = deicde(6,0)
    println(vn)
  }
}
object test_if extends App {
  var x:Int=0;
  var msg:Any = if(x>10){
    "OK"
  }else if(x==10){
    "no"
  } else{
    123
  }
  println(msg)
}

//复合表达式
object sxp extends App{
  /*val average = {
    print("Enter a number: ")
    val v1 = Console.in.readLine().toDouble
    print("Enter a number: ")
    val v2 = Console.in.readLine().toDouble
    (v1+v2)/2
  }
  println(average)*/

  println{
    var x = 2
    while (x < 1000) x *= 2
    x
  }

  var in = new FileInputStream("src/testfile")
  var len = 0;
  while ({len = in.read();len!= -1}){
//    var vv = len.toChar
//    println(vv)
    println(len)
  }
  var vvv = Console.in.readLine()
  Console.println(vvv)
  Array(100,200,300).map{x => println(x); println("hello")}
}
object forTest extends App{
//  for(i <- 0 until  10){
//  for(i <- 0 to 10 by 3)
//    if(i%2==0){
//      println(i)
//  }
//  println("1--------------------------")
//  for(i<-1 to 10;j <- 1 to 5){
//    println(i+","+j)
//  }

//  var from=
  /*for(i <- 1 to 10;from = 10-i;j <- 5 to i){
    println(from)
  }*/
  //独立添加守卫
  /*for(i<- 1 to 10;if(i==5);j <- 20 to 100; if(j==25))
    println(i+","+j)*/
  //yield
  /*val n = for(i <- 1 to 10) yield i%3
  println(n)
  var arr:Array[Int]=
    for(i<- Array(100,200,300)) yield i
  println(arr(1))

  var arr1=Array(10,60,54,34).zipWithIndex
  for((x,y)<-arr1){
    println(x+"--"+y)
  }*/
}
//模式匹配
object matchtest extends App {
//  var s :String="test"
//  s match {
//    case "tt" => println("hh")
//    case "jj" => println("jj")
//    case "ll" => println("ll")
//    case "test" => println("hhhsss")
//    case _ => println("nn")
//  }
//  var s1=521
//  var myNum=521
//  s1 match {
//    case 98 => println("test")
//    case myNum => println(myNum+"test")
//    case _ =>println("无匹配项")
//  }
//  var s:Any="test";
//  var tr = List[String]
//  var vs:Any =tr
  /*var s:Any=154;
  s match {
    case x if(x==null) => true
    case "tes" => println(false)
    case z:String => println(z)
    case t:Int => println("Int")
    case l:List[_] => println("List")
  }*/
//  var opt =
//  opt match {
//    case Some(info) =>info
//    case None =>println("空对象")
//  }
}
object arr{
  def mathchArr(s:Array[Int]):String= {
    s match {
      case Array(0) => "Array(0)"
      case Array(2, 3) => 2 + "_" + 3
      case Array(0, _*) => "Start from 0"
      case _ => "其它类型"
    }
  }
  def main(args: Array[String]): Unit = {
    var arr =Array[Int](0,1)
    var value:String= mathchArr(arr)
    println(value)

    var value1:String= mathchArr(Array(0 to 10).flatten)
    println(value1)
  }
}
object optionTest{
  def main(args: Array[String]): Unit = {
//    var s = 12;
//    s match {
//      case x if(x>12)=> println(x)
//      case _ => println("QI")
//    }
    var map = Map("key"->"value","key2"->"value2")
    var v = map.get("key2")
    v match {
      case Some(value)=>println(value)
      case None=>println("NO")
    }
    println(v)
//    map.foreach(println(_))
//    map.foreach(x=>println(x._1+"---"+x._2))
  }
}
//样例类
class persion
case class teacher(name:String,subject:String) extends persion
case class student(name:String,classroom:String) extends persion
object Case_Class {
  def person(p:persion)={
    p match {
      case teacher(name:String,subject:String)=>println("teacher")
      case student(name:String,classroom:String)=>println("student")
    }
  }
  def main(args: Array[String]): Unit = {
    var s = student("zhangsan","201")
    println(s)
    person(s)
  }
}
trait animal{
  def eat()
}
class Dog extends animal{
  override def eat(): Unit = println("Dog eat")
}
class Cat extends animal{
  override def eat(): Unit = println("Cat eat")
}
object typetest{
  def main(args: Array[String]): Unit = {
    var a:animal=new Dog
    if(a.isInstanceOf[Cat]){
      val c:Cat=a.asInstanceOf[Cat]
      c.eat()
    }
    a match {
      case a:Cat=>a.eat()
      case a:Dog=>a.eat()
    }
  }
}
//sealed class
sealed abstract class Expr
   case class Number(n:Int) extends Expr
  case  class Sum(e1 : Expr , e2 : Expr) extends Expr
   case class Mul(e1 : Expr , e2 : Expr) extends Expr
object sealedclass{
  def getType(a:Expr)={
    (a : @unchecked) match {
//    a match {
      case Number(n:Int)=>println("Number")
      case Sum(e1 : Expr , e2 : Expr)=>println("Sum")
      case Mul(e1 : Expr , e2 : Expr)=>println("Mul")
    }
  }

  def main(args: Array[String]): Unit = {
    var n = new Number(11)
    getType(n)
  }
}
object pFunction{
  def main(args: Array[String]): Unit = {
    /*var f :PartialFunction[Int,String]={
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
    }
//    var n = f.apply(3)
//    println(n)
    var v = f.isDefinedAt(4)
    println(v)*/


    /*var f0 :PartialFunction[Int,String]={case 0 => "0"}
    var f2 :PartialFunction[Int,String]={case 2 => "two"}
    var f1 :PartialFunction[Int,String]={case 1 => "one"}
    var f3 :PartialFunction[Int,String]={case 3 => "three"}

    var f = f0 orElse f1 orElse f3 orElse f2
    var flage = f.isDefinedAt(2)
    var valie = f(3)
    println(valie)*/


    var f1:PartialFunction[Int,String]={
      case 1=> "one"
      case 2=> "two"
      case 3=> "three"
      case 4=> "four"
    }
    var f = f1.applyOrElse(5,{x:Int=>"briup"})
    println(f)
  }
}
//插值器
object insertValue{
  def main(args: Array[String]): Unit = {
    /*var name = "briup"
    println(s"start$name\ndsaf")
    println(raw"start$name\ndsaf")*/


    val height=1.9d;
    val name="James"
    println(f"$name%s is $height%2.2f neters tall")
  }

}
object functionparimater{
  def fun(n:Int,s:String*):String={
    s+"String"
  }
  def main(args: Array[String]): Unit = {
    var arr = Array[String]("hdfs","dfs","-ls")
    var v = fun(1,arr:_*)
    println(v)
  }
}

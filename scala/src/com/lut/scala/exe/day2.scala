package com.lut.scala.exe

import scala.collection.mutable.ArrayBuffer

/**
  * @author qsg
  * @Date 2019/11/26 19:18
  * @describe
  * @version 1.0
  **/
class day2 {
  def addtwo = (x:Int,y:Int)=>x+y
  def addtwo1 = (x:Int)=>x
  def addthree:(Int,Int,Int)=>Int = (x:Int,y:Int,z:Int)=>x+y+z

}
object day2{
  def addtwo1 = (x:Int,y:Int)=>x+y
  def main(args: Array[String]): Unit = {
    var d = new day2
    var v1 =  d.addtwo
    var v2  = day2 addtwo1 (1,5)
    println(persion show "show")
    println(v1)
    println(v2)
    println("---------------")

  }
}

object persion{
  def show(name:String)={
    name
  }
}

//单列模式
class student private{}
object student{
  var STUDENT=new student

  def main(args: Array[String]): Unit = {
    var s  =student.STUDENT
    var s1 =student.STUDENT
    var s2 =student.STUDENT
    var s3 =student.STUDENT
    println(s)
    println(s1)
    println(s2)
    println(s3)
  }
}

//样例类 case 重写了equals方法，toString方法
case class point(x:Int,y:Int){}
object point_Test{
  def main(args: Array[String]): Unit = {
    var p1 = new point(1,2)
    var p2 = new point(1,3)
    var p3 = new point(1,2)
    println(p1==p2)
    println(p1==p3)//true
    println(p2==p3)
  }
}
//对象的声明 伴生对象
case class a(){
  println("dfsfs")
  def t()={
    println("tt")
  }
}
object a{
  def main(args: Array[String]): Unit = {
    println(new a)
  }
}
//伴生对象可以访问私有属性
class b{
  println("ttttt")
  println("ttttt")
  println("ttttt")
  private var name:String=_
}
object b{
  def main(args:Array[String]):Unit={
    //访问私有属性时必须new
    println(new b().name)
    var g =  b//b的匿名子类
    println(g)
  }
  def show(name:String)={
    name
  }
}
object c1{
  def show (name:String)={
    name
  }
}
class c{
  def apply: c = new c()
}
object c{
  def main(args: Array[String]): Unit = {
    var a:Int = 12;
    //var b:Int = a.+(11)
    var b:Int = a+(11)
    println(b)
    c1 show "name"
    var t1 = c
    println(t1)
  }
}

//特质
trait persion{
  var name:String
  var age:Int
  def say(name:String)
  def go()={
    println("跑")
  }
}
class stu extends persion with Serializable{
  override var name: String = "fg"
  override var age: Int = 18

  override def say(name: String): Unit = println(name)//name

  //def apply: stu = new stu()
}
object persionTest{
  def main(args: Array[String]): Unit = {
    new persion {
      override def say(name: String): Unit = println(name)

      override var name: String ="ttee"
      override var age: Int =20
    }.say("lisi")
    var s =new stu;
    println(s)
  }
}
//例子
trait Iterator[A]{
  def hasNext():Boolean
  def next():A
}
class IntIterator(to:Int) extends Iterator[Int]{
  private var current:Int=0
  override def hasNext(): Boolean = current<to

  override def next(): Int = {
    if(hasNext){
      val t = current
      current +=1
      t
    } else 0
  }
}
object IntIterator{
  def main(args: Array[String]): Unit = {
   var it1 =  new IntIterator(10)
    var v = it1.next()
    println(v)
    var v1 = it1.next()
    println(v1)
  }
}
trait Pet{
  val name:String
}
class Cat(val name:String) extends Pet
//  override val name: String = _
class Dog(val name:String) extends Pet
object animal {
  def main(args: Array[String]): Unit = {
    val anim = ArrayBuffer.empty[Pet]
    val dog = new Dog("大黑狗")
    val cat = new Cat("大肥猫")
    anim.append(dog)
    anim.append(cat)
    anim.foreach(pet=>println(pet.name))
  }
}
//混入
/*abstract class A {
  val message: String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}
class D extends B with C
object D extends App {
  val d = new D
  println(d.message)  // I'm an instance of class B
  println(d.loudMessage)  // I'M AN INSTANCE OF CLASS B
}*/
//类型声明
object d{
  def main(args: Array[String]): Unit = {
    var name :String="test..."
    type a=Int
    var s:a=20
    println(s)
    var st = name.*(3)
    println(st)

    //var 67="ddd"
  }
}









package com.lut.scala.Day1

import java.util

import scala.beans.BeanProperty

/**
  * @author qsg
  * @Date 2019/11/25 16:55
  * @describe 类中不能写静态的东西
  * @version 1.0
  **/
class Student(@BeanProperty var name:String, age:Int) {
  /*

  主构造器 在类名后面紧紧跟着
  从构造器 在类内部声明的构造器
           内部构造器用this 必须依附于其它构造器

   */

  def this(){
    this("jake",20);
    this.show
  }

  def this(name:String){
    this(name,18)
    this
  }
  private var gender:Boolean=_;

  def show:Unit=println(name+"_"+age)

  override def toString: String = gender+"_"+name+"_"+test

  def test():String="你好世界"

//  var v2 = util.TreeSet[Student]
  var v3=(x:Int,y:Int)=>x+y;

}


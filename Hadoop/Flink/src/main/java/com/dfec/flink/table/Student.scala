package com.dfec.flink.table

/**
  * @author qsg
  * @Classname Student
  * @version 1.0 v
  * @Date 2020/7/31 9:08
  * @Copyright DFEC
  **/
case class Student(id:Int,name:String){
  override def toString: String = {
    "{'id':"+this.id+",'name':'"+this.name+"'}"
  }
}
package com.lut.scala.Day1

/**
  * @author qsg
  * @Date 2019/11/25 17:06
  * @describe
  * @version 1.0
  **/
object Stu {
  //只是语法层面的逻辑单位，只是解决静态的东西写在哪里
    def main(args: Array[String]): Unit = {
      var s=new Student("zhangsan",20)
      s.show
      println(s)
      var s1=new Student()
      s1.show
      println(s1)
      println("-----------------")
      var s2 = new Student("lili")
      s2.name="wang"
      s2.show
      print(s2)


    }

}

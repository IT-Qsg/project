package sp_sc.util

import java.io.File

/**
  * @author qsg
  * @Date 2019/12/4 9:40
  * @describe
  * @version 1.0
  **/
object Init {
  def init()={
//    val path = new File(".").getCanonicalPath()
//    //File workaround = new File(".");
//    System.getProperties().put("hadoop.home.dir", path);
//    new File("./bin").mkdirs();
//    new File("./bin/winutils.exe").createNewFile();
    System.setProperty("hadoop.home.dir","D:\\360极速浏览器下载\\hadoop-common-2.2.0-bin-master")
  }

}

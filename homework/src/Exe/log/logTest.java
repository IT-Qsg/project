package Exe.log;

import org.apache.log4j.Logger;

public class logTest {
    public static void main(String[] args) {
        Log.logger.info("main 方法");
    }
}
interface Log{
   public static final Logger logger = Logger.getLogger(Log.class.getName());
}
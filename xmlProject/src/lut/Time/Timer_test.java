package lut.Time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/27 15:10
 * @describe
 **/
public class Timer_test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("你好");
            }
        },10000,1000);
    }
}

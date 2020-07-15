package com.dfec.springbootmybatis.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/9 17:12
 * @describe 调度 在特定时间执行任务
 **/
@Component
public class Scheduler {
    /**
     * 并不是完全按照规定执行 可能存在微小的时间差异
     */

    //每分钟执行一次
    @Scheduled(cron = "0/60 * *  * * ? ")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("一分钟执行一次    @_@       Java cron job expression:: " + strDate);
    }
    @Scheduled(fixedRate = 1000)
    public void fixedRateSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("一秒执行一次 Fixed Rate scheduler:: " + strDate);
    }
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelaySch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("三秒后执行 Fixed Delay scheduler:: " + strDate);
    }
}

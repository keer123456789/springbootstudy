package com.keer.scheduleddemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.scheduleddemo
 * @Author: keer
 * @CreateTime: 2020-03-06 21:34
 * @Description: 定时任务
 */
@Component
public class ScheduledTask {

    /**
     * 表示任务之间间隔： 具体是指两次任务开始的时间间隔，
     * 即第二次任务开始的时间，第一次任务还没有完成
     * 例如：每次任务执行需要3秒，时间间隔2秒，第一次任务开始时间0，第二次任务开始时间2
     */
    @Scheduled(fixedRate = 1000)
    public void fixedRateTest() {
        System.out.println("fixedRateTest start >>" + new Date());

    }

    /**
     * 表示上一次任务结束和下一次任务开始之间的时间间隔
     */
    @Scheduled(fixedDelay = 2000)
    public void fixedDelayTest() {
        System.out.println("fixedDelayTest start >>" + new Date());
    }

    /**
     * initialDelay 表示首次任务启动的延迟时间
     */
    @Scheduled(initialDelay = 2000, fixedDelay = 2000)
    public void initialDelayTest() {
        System.out.println("initialDelayTest >>" + new Date());
    }

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void cornTest() {
        System.out.println("cornTest >>" + new Date());
    }
}

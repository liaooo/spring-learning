package com.liao.example.schedule.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Scheduled 注解声明方法是一个计划执行的方法
 * fixedRate 每隔多少时间执行一次
 * cron 指定时间执行
 * fixDelay 前后执行间隔时间
 */
@Service
public class ScheduledTaskService {

    @Scheduled(fixedRate = 5000)
    public void fixTime() {
        System.out.println("每隔5秒执行：" + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 5 17 ? * *")
    public void fixRate() {
        System.out.println("指定时间执行" + System.currentTimeMillis());
    }
}

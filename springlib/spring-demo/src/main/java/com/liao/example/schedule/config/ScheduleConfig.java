package com.liao.example.schedule.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling 开启对计划任务的支持
 */
@Configuration
@ComponentScan("com.liao.example.schedule")
@EnableScheduling
public class ScheduleConfig {
}

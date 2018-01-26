package com.liao.example.schedule;

import com.liao.example.schedule.config.ScheduleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ScheduleConfig.class);
    }
}

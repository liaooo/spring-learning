package com.liao.example.lifecycle;

import com.liao.example.lifecycle.config.LifeCycleConfig;
import com.liao.example.lifecycle.service.BeanWayService;
import com.liao.example.lifecycle.service.JSR250WayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        BeanWayService beanWayService = ctx.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = ctx.getBean(JSR250WayService.class);
        ctx.close();
    }
}

package com.liao.example.aop;

import com.liao.example.aop.config.AopConfig;
import com.liao.example.aop.service.ActionService;
import com.liao.example.aop.service.MethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AopConfig.class);
        ActionService actionService = ctx.getBean(ActionService.class);
        MethodService methodService = ctx.getBean(MethodService.class);
        actionService.add();
        methodService.add();
        methodService.print("hello");
        methodService.error();
        ctx.close();
    }
}

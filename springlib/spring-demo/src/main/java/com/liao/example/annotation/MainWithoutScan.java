package com.liao.example.annotation;

import com.liao.example.annotation.config.JavaConfigWithoutScan;
import com.liao.example.annotation.service.UseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWithoutScan {
    public static void main(String[] arsg) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(JavaConfigWithoutScan.class);
        UseService service = ctx.getBean(UseService.class);
        System.out.println(service.sayHello("jason"));
        ctx.close();
    }
}

package com.liao.example.annotation;

import com.liao.example.annotation.config.JavaConfig;
import com.liao.example.annotation.service.UseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] str) {
        /**
         * 传入一个JAVA配置类参数
         */
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseService service = ctx.getBean(UseService.class);
        System.out.println(service.sayHello("liao"));
        ctx.close();
    }
}

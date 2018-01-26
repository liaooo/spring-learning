package com.liao.example.annotation;

import com.liao.example.annotation.config.ComboConfig;
import com.liao.example.annotation.service.UseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainComboConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ComboConfig.class);
        UseService service = ctx.getBean(UseService.class);
        System.out.println(service.sayHello("liao"));
        ctx.close();
    }
}

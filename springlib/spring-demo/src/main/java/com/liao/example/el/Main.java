package com.liao.example.el;

import com.liao.example.el.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = ctx.getBean(ElConfig.class);
        elConfig.outputResource();
        ctx.close();
    }
}

package com.liao.example.aware;

import com.liao.example.aware.config.AwareConfig;
import com.liao.example.aware.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = ctx.getBean(AwareService.class);
        awareService.printResult();
        ctx.close();
    }
}

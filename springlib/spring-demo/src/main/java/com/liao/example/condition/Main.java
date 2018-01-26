package com.liao.example.condition;

import com.liao.example.condition.config.ConditionConfig;
import com.liao.example.condition.service.IListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ConditionConfig.class);
        IListService listService = ctx.getBean(IListService.class);
        System.out.println(listService.showListCmd());
        ctx.close();
    }
}

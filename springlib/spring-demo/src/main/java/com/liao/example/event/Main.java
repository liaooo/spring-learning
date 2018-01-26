package com.liao.example.event;

import com.liao.example.event.config.EventConfig;
import com.liao.example.event.event.DemoEvent;
import com.liao.example.event.publisher.DemoPubliser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(EventConfig.class);
        ctx.publishEvent(new DemoEvent(ctx, "容器发布的事件"));
        DemoPubliser demoPubliser = ctx.getBean(DemoPubliser.class);
        demoPubliser.publish("publiser发布的事件");
        ctx.close();
    }
}

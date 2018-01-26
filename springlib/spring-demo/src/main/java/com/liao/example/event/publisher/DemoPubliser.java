package com.liao.example.event.publisher;

import com.liao.example.event.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 自定义事件发布类
 */
@Component
public class DemoPubliser {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }

    @Override
    public String toString() {
        return "DemoPubliser{}";
    }
}

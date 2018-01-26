package com.liao.example.event.listener;

import com.liao.example.event.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 创建一个监听器，并指定监听事件类型
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /**
     * 接收消息并处理
     * @param demoEvent
     */
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("DemoListener接收到来自" + demoEvent.getSource() + "的讯息：" + demoEvent.getMsg());
    }
}

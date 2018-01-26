package com.liao.example.thread.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Async 注解声明该方法是一个异步方法
 */
@Service
public class TaskExecutorService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行任务：" + i);
    }

    @Async
    public void executeAsyncPlusTask(Integer i) {
        System.out.println("执行任务：" + (i + 1));
    }
}

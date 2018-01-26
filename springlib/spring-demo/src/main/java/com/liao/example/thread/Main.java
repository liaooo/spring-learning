package com.liao.example.thread;

import com.liao.example.thread.config.AsyncTaskConfig;
import com.liao.example.thread.service.TaskExecutorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] ars) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AsyncTaskConfig.class);
        TaskExecutorService executor = ctx.getBean(TaskExecutorService.class);

        for (int i = 0; i < 10; i++) {
            executor.executeAsyncTask(i);
            executor.executeAsyncPlusTask(i);
        }
        ctx.close();
    }
}

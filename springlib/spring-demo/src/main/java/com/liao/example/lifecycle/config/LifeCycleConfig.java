package com.liao.example.lifecycle.config;

import com.liao.example.lifecycle.service.BeanWayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.liao.example.lifecycle")
public class LifeCycleConfig {

    /**
     * initMethod 构造之后执行
     * destroyMethod 销毁之前执行
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanWayService beanWayService() {
        return new BeanWayService();
    }
}

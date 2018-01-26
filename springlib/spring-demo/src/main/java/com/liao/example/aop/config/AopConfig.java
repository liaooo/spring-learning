package com.liao.example.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * JAVA配置类
 * @EnableAspectJAutoProxy 声明开启Spring对AspectJ的支持
 */
@Configuration
@ComponentScan("com.liao.example.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}

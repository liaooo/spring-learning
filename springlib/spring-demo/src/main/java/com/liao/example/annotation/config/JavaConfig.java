package com.liao.example.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * java配置类
 * @Configuration 表示该类是一个配置类
 * @ComponentScan 告诉容器扫描指定包下面的注解
 */
@Configuration
@ComponentScan("com.liao.example.annotation")
public class JavaConfig {

}

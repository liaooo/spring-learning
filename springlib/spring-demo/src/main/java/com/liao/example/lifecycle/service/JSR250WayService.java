package com.liao.example.lifecycle.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct 构造之后执行
 * @PreDestroy 销毁之前执行
 */
@Service
public class JSR250WayService {

    @PostConstruct
    public void init() {
        System.err.println("初始化构造JSR250WayService");
    }

    public JSR250WayService() {
        super();
        System.err.println("构造JSR250WayService");
    }

    @PreDestroy
    public void destroy() {
        System.err.println("销毁JSR250WayService");
    }

}

package com.liao.example.lifecycle.service;


public class BeanWayService {

    public void init() {
        System.err.println("初始化构造BeanWayService");
    }

    public BeanWayService() {
        super();
        System.err.println("构造BeanWayService");
    }

    public void destroy() {
        System.err.println("销毁BeanWayService");
    }
}

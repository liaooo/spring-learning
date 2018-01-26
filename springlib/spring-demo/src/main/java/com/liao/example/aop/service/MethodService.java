package com.liao.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MethodService {

    public void add(){}

    public void error(){
        throw new RuntimeException();
    }

    public boolean print(String str) {
        System.out.println(str);
        return true;
    }
}

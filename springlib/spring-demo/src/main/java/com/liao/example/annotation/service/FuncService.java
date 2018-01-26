package com.liao.example.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class FuncService {

    public String sayHello(String str) {
        return "Hello " + str;
    }
}

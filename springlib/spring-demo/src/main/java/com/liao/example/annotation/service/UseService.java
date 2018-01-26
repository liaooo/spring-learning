package com.liao.example.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseService {

    @Autowired
    FuncService funcService;

    public void setFuncService(FuncService funcService) {
        this.funcService = funcService;
    }

    public String sayHello(String str) {
        return funcService.sayHello(str);
    }
}

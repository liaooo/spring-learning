package com.liao.example.aop.service;


import com.liao.example.aop.annotation.Action;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Action(name="注解的add()方法")
    public void add(){}

}

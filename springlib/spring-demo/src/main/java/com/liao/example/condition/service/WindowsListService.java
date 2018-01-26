package com.liao.example.condition.service;

import com.liao.example.condition.cond.WindowsCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(WindowsCondition.class)
@Service
public class WindowsListService implements IListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}

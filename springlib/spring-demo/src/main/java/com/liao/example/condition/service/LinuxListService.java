package com.liao.example.condition.service;

import com.liao.example.condition.cond.LinuxCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @Conditional 注解配置满足指定条件才创建bean
 */
@Conditional(LinuxCondition.class)
@Service
public class LinuxListService implements IListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}

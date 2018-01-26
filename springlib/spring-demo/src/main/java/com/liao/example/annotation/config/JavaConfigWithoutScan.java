package com.liao.example.annotation.config;

import com.liao.example.annotation.service.FuncService;
import com.liao.example.annotation.service.UseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JAVA配置类
 * @Bean 注解在方法上 方法返回值就是创建的bean对象
 */
@Configuration
public class JavaConfigWithoutScan {

    @Bean
    public FuncService funcService() {
        return new FuncService();
    }

    @Bean
    public UseService useService() {
        UseService useService = new UseService();
        useService.setFuncService(funcService());
        return useService;
    }

    /**
     * 该方法同上一方法一样的效果
     */
/*    @Bean
    public UseService useService(FuncService funcService) {
        UseService useService = new UseService();
        useService.setFuncService(funcService);
        return useService;
    }*/
}

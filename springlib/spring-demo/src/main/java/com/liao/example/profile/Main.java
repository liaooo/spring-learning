package com.liao.example.profile;

import com.liao.example.profile.bean.DemoBean;
import com.liao.example.profile.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext();
        // 激活prod配置Profile
        ctx.getEnvironment().setActiveProfiles("prod");
        // 注册配置
        ctx.register(ProfileConfig.class);
        ctx.refresh();

        DemoBean demoBean = ctx.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        ctx.close();
    }
}

package com.liao.example.config;

import com.liao.example.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 有@EnableWebMvc注解  重写的WebMvcConfigurerAdapter的方法才会有效
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.liao.example")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * 配置JSP的ViewResolver
     * SpringMVC渲染视图的核心机制，所有的*ViewResolver都实现ViewResolver这个接口
     * 并重写resolveViewName()方法，该方法返回View，它的作用就是使用模型数据渲染视图返回给浏览器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 重写方法 配置静态资源访问路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
    }

    /**
     * 快捷配置路径跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 此处配置和HelloController的hello方法同效
        registry.addViewController("/").setViewName("/index");
    }

    /**
     * 请求路径最后带后缀，默认会忽略后缀，如：http://localhost/app/xx.yy 会忽略.yy
     * 可配置不忽略
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /**
     * 重写方法 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
}

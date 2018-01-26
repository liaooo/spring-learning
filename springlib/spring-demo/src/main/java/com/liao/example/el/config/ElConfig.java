package com.liao.example.el.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @PropertySource 引入配置文件，引入的配置用$ 且需配置一个PropertySourcesPlaceholderConfigurer
 */
@Configuration
@ComponentScan("com.liao.example.el")
@PropertySource("classpath:test.properties")
public class ElConfig {

    /**
     * 普通注入
     */
    @Value("I LOVE U")
    private String normal;

    /**
     * 引用系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String sysProps;

    /**
     * 引用其他bean的属性
     */
    @Value("#{demoService.author}")
    private String fromOther;

    /**
     * 直接引入文件
     */
    @Value("classpath:test.txt")
    private Resource testFile;

    /**
     * 从网址引入资源
     */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(sysProps);
            System.out.println(fromOther);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

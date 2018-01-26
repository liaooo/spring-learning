package com.liao.example.aware.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements ResourceLoaderAware, BeanNameAware {

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void printResult() {
        System.out.println("BeanName=" + beanName);
        Resource resource = loader.getResource("classpath:test.txt");
        try {
            System.out.println("外部资源：\n" + IOUtils.toString(resource.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

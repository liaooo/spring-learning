package com.liao.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * WebApplicationInitializer 用来配置Servlet3.0+的接口，以代替web.xml
 * 实现此接口将会自动被SpringServletContainerInitializer获取，以启动Servlet容器
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //注册WebApplicationContext 冰关联当前ServletContext
        AnnotationConfigWebApplicationContext ctx
                = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        ctx.setServletContext(servletContext);

        // 注册SpringMVC的DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}

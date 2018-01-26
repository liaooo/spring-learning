package com.liao.example.aop.aspect;

import com.liao.example.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Aspect 声明一个切面
 * @Pointcut 声明一个切点
 * @After @Before @Around @AfterReturning @AfterThrowing 声明在切点上的通知
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.liao.example.annotation.Action)")
    public void annotationPointcut(){}

    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("方法执行后：注解式拦截 " + action.name());
    }

    @Before("execution(* com.liao.example.service.MethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法执行前：规则式拦截 " + method.getName());
    }

    @AfterThrowing("execution(* com.liao.example.service.MethodService.*(..))")
    public void error(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法执行异常：规则式拦截 " + method.getName());
    }

    @Around("execution(* com.liao.example.service.MethodService.*(..)))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            args[0] = "增强前缀：" + args[0];
        }
        return joinPoint.proceed(args);
    }

    @AfterReturning("execution(* com.liao.example.service.MethodService.*(..))")
    public void afterReturn(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法执行后返回结果前：规则式拦截 " + method.getName());
    }
}

package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    @AfterReturning(pointcut = "within(com.codegym.controller.*)", returning = "result")
    public void log(JoinPoint joinPoint, Object result){
        System.out.println("Start log");
        String className= joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        System.out.println(className + "" + method);
        if (result==null){
            System.out.println("null");
        }else {
            System.out.println(result.hashCode());
        }
    }
}

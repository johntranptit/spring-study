package com.example.springbootdocker.aop.ex1;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterSingAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("clap! clap! clap!");
    }

}

package com.agorohov.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("com.agorohov.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice(){
        System.out.println("beforeAddExceptionHandlingAdvice: ловим/обрабатываем исключение при попытке добавить книгу/журнал");
        System.out.println("----------------------------");
    }
    
//    @Before("com.agorohov.spring.aop.aspects.MyPointcuts.allGetMethods()")
//    public void beforeGetExceptionHandlingAdvice(){
//        System.out.println("beforeGetExceptionHandlingAdvice: ловим/обрабатываем исключение при попытке получить книгу/журнал");
//    }
}

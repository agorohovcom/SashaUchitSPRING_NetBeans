package com.agorohov.spring.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}
    
//    @Pointcut("execution(* get*())")
//    public void allGetMethods(){}
}

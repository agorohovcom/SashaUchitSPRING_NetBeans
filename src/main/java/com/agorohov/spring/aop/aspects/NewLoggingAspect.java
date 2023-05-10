package com.agorohov.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundReturnBookAdvice: В библиотеку пытаются вернуть книгу");

//        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = pjp.proceed();
        }
        catch(Exception e){
            System.out.println("aroundReturnBookAdvice: было поймано исключение " + e);
//            targetMethodResult = "Неизвестное название книги";
            throw e;
        }
                
                
//        targetMethodResult = "Преступление и наказание";
                //        long end = System.currentTimeMillis();
                System.out.println("aroundReturnBookAdvice: в библиотеку успешно вернули книгу");
//        System.out.println("aroundReturnBookAdvice: метод returnBook выполнил работу за " + (end-begin) + " миллисекунд");

        return targetMethodResult;
    }
}

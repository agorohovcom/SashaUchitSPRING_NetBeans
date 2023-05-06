package com.agorohov.spring.aop.aspects;

import com.agorohov.spring.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    
//    @Pointcut("execution(* com.agorohov.spring.aop.UniLibrary.*(..))")
//    private void allMethodsFromUnilibrary(){}
//    
//    @Pointcut("execution(public void com.agorohov.spring.aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUnilibrary(){}
//    
//    @Pointcut("allMethodsFromUnilibrary() && !returnMagazineFromUnilibrary()")
//    private void allMethodsExectReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodsExectReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExectReturnMagazineFromUniLibraryAdvice(){
//        System.out.println("beforeAllMethodsExectReturnMagazineFromUniLibraryAdvice: writting Log #10");
//    }
    
    // __________________________________________
//    @Pointcut("execution(* com.agorohov.spring.aop.UniLibrary.get*())")
//    private void allGetMethodsFromUnilibrary() {
//    }
//
//    @Pointcut("execution(* com.agorohov.spring.aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUnilibrary() {
//    }
//    
//    // комбинация первого и второго Pointcut
//    @Pointcut("allGetMethodsFromUnilibrary() || allReturnMethodsFromUnilibrary()")
//    private void allGetAndReturnMethodsFromUnilibrary() {
//    }
//
//    @Before("allGetMethodsFromUnilibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writting Log #1");
//    }
//
//    @Before("allReturnMethodsFromUnilibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writting Log #2");
//    }
//    
//    @Before("allGetAndReturnMethodsFromUnilibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writting Log #3");
//    }
    // __________________________________________
//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){}
    
//    @Before("execution(public void com.agorohov.spring.aop.UniLibrary.getBook())")
//    @Before("execution(public void get*())")
//    @Before("execution(public void get*(String))")
//    @Before("execution(public void get*(*))")
//    @Before("execution(* *(..))")
//    @Before("execution(public void getBook(com.agorohov.spring.aop.Book))")
    
    
    
    @Before("com.agorohov.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        
        MethodSignature mSign = (MethodSignature) joinPoint.getSignature();
        System.out.println("mSign = " + mSign);
        System.out.println("mSign.getMethod() = " + mSign.getMethod());
        System.out.println("mSign.getReturnType() = " + mSign.getReturnType());
        System.out.println("mSign.getName() = " + mSign.getName());
        
        if(mSign.getName().equals("addBook")){
            Object [] arg = joinPoint.getArgs();
            for(Object obj: arg){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: "
                            + "название: " + myBook.getName() +
                            ", автор: " + myBook.getAuthor() +
                            ", год издания: " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }
        
        System.out.println("beforeAddBookAdvice: логгирование попытки добавить книгу/журнал");
        System.out.println("----------------------------");
    }
    
//    @Before("com.agorohov.spring.aop.aspects.MyPointcuts.allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetBookAdvice: логгирование попытки получить книгу/журнал");
//    }
    
    
//    
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
//    }
//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
//    }
}

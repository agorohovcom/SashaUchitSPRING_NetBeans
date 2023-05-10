package com.agorohov.spring.aop.aspects;

import com.agorohov.spring.aop.Student;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UnivercityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice(){
//        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получение списка студентов перед метором getStudents");
//    }
//    
//    @AfterReturning(pointcut = "execution(* getStudents())",
//            returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(JoinPoint jp, List<Student> students){
//        Student firstStudent = students.get(0);
//        
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//        
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade+1;
//        firstStudent.setAvgGrade(avgGrade);
//        
//        
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логгируем получение списка студентов после работы метода getStudents");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())",
//            throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логгируем выброс исключения " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: логгируем любое завершение метода (нормальное или ошибка)");
    }
}

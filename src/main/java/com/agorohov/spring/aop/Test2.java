package com.agorohov.spring.aop;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch (Exception e) {
            System.out.println("Было выброшено исключение " + e);
        }

        context.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agorohov.spring.aop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author agorohov
 */
@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("ZaurTregulov", 4, 7.5);
        Student st2 = new Student("Aleksandr Gorohov", 2, 8.3);
        Student st3 = new Student("Elena Sidorova", 1, 9.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    
    public List<Student> getStudents(){
        System.out.println("Начало работы метода getStudents");
        
        // для вызова исключения
        System.out.println(students.get(3));
        
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}

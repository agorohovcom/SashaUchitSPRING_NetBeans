/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agorohov.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
//    @Autowired
//    @Qualifier("dog")
    private Pet pet;
//    @Value("Gorohov")
    @Value("${person.surname}")
    private String surname;
//    @Value("33")
    @Value("${person.age}")
    private int age;

    @Autowired
    public Person(@Qualifier("dog") Pet pet){  
        System.out.println("Person bean is created");
        this.pet = pet;
    }
    
//    public Person() {
//        System.out.println("Person bean is created");
//    }

    // "pet -> setPet"
//    @Autowired
//    @Qualifier("dog")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");

        this.age = age;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}

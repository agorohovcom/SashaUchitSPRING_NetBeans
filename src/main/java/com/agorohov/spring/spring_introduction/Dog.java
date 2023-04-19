package com.agorohov.spring.spring_introduction;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Dog implements Pet{
//    private String name;

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Dog(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Wow!");
    }

    @PostConstruct
    public void myIit(){
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("Class Dog: destroy method");
    }
}

package com.agorohov.spring.sashaUchitSPRING_NetBeans.spring_introduction;

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

    public void myIit(){
        System.out.println("Class Dog: init method");
    }

    public void myDestroy(){
        System.out.println("Class Dog: destroy method");
    }
}

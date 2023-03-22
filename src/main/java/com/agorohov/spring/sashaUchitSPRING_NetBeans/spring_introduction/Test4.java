package com.agorohov.spring.sashaUchitSPRING_NetBeans.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml"/*, "applicationContext.xml"*/);

        Dog myDog = context.getBean("myPet", Dog.class);
//        myDog.setName("Belka");
        Dog yourDog = context.getBean("myPet", Dog.class);
//        yourDog.setName("Strelka");

//        System.out.println(myDog.getName());
//        System.out.println(yourDog.getName());

        System.out.println("Переменные ссылаются на один и тот же объект? " +
                (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();
    }
}

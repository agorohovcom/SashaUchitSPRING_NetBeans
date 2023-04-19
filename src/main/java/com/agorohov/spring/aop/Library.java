package com.agorohov.spring.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public void getBook(){
        System.out.println("Мы берём книгу");
    }
    
}

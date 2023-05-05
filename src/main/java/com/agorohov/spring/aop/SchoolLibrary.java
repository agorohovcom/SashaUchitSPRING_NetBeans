package com.agorohov.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{
    
//    @Override
    public void getBook(){
        System.out.println("Мы берём книгу в SchoolLibrary");
    }
    
}

package com.agorohov.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{
    
//    @Override
    public void getBook(){
        System.out.println("Мы берём книгу в UniLibrary");
    }
    
//    public void getBook(String bookname){
//        System.out.println("Мы берём книгу в UniLibrary \"" + bookname + "\"");
//    }
    
//    public void getBook(Book book){
//        System.out.println("Мы берём книгу в UniLibrary \"" + book.getName() + "\"");
//    }
    
//    public String returnBook(){
//        System.out.println("Возвращаем книгу в UniLibrary");
//        return "OK";
//    }
    
    public void returnBook(){
        System.out.println("Мы возвращаем книгу в UniLibrary");
    }
    
    public void getMagazine(){
        System.out.println("Мы берём журнал в UniLibrary");
    }
    
    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniLibrary");
    }
    
    public void addBook(){
        System.out.println("Мы добавляем книгу в UniLibrary");
    }
    
    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniLibrary");
    }
}

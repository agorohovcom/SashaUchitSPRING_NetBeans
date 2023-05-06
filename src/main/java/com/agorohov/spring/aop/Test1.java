package com.agorohov.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        
        
        uniLibrary.getBook();
//        uniLibrary.getBook("Преступление и наказание");
//        uniLibrary.returnBook();
//        uniLibrary.getMagazine();
//        uniLibrary.getMagazine(33);
//        uniLibrary.returnMagazine();
//        uniLibrary.addBook();
        uniLibrary.addBook("Sasha", book);
        uniLibrary.addMagazine();

//        uniLibrary.getBook(book);
//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
        context.close();
    }

}

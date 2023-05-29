package com.agorohov.spring.hibernateTest;

import com.agorohov.spring.hibernateTest.entity.Employee1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee1.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee1 emp = new Employee1(
                    "Anatoliy", 
                    "Vassernam", 
                    "HR", 
                    100);

            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();
            
            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee1 empFromDB = (Employee1) session.get(Employee1.class, myId);
            session.getTransaction().commit();
            System.out.println(empFromDB);

            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

package com.agorohov.spring.hibernateTest;

import com.agorohov.spring.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test1 {

    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .addResource("hibernate.cfg.xml")
//                .addClass(Employee.class)
//                .buildSessionFactory();
        
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

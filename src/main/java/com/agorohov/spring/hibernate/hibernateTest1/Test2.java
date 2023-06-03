package com.agorohov.spring.hibernate.hibernateTest1;

import com.agorohov.spring.hibernate.hibernateTest1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee(
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
            Employee empFromDB = (Employee) session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(empFromDB);

            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

package com.agorohov.spring.hibernateTest;

import com.agorohov.spring.hibernateTest.entity.Employee;
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
                    "Elena", 
                    "Petrova", 
                    "Sales", 
                    800);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            
            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee empFromDB = (Employee) session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(empFromDB);
            
            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

package com.agorohov.spring.hibernateTest;

import com.agorohov.spring.hibernateTest.entity.Employee1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test1 {

    public static void main(String[] args) {
        // так не работает
//        SessionFactory factory = new Configuration()
//                .addResource("hibernate.cfg.xml")
//                .addClass(Employee.class)
//                .buildSessionFactory();
        
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee1.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

//            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
//            Employee emp = new Employee("Sasha", "Gorohov", "furnFactory", 90);
//            Employee emp = new Employee("Zinka", "Rezinka", "HR", 300);
            Employee1 emp = new Employee1("Aleksandr", "Ivanov", "IT", 600);

            
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            
            System.out.println(emp);
            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

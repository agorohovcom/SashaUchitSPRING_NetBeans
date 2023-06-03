package com.agorohov.spring.hibernateTest1;

import com.agorohov.spring.hibernateTest1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test4_DELETE {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // пример 1
//            Employee emp = (Employee) session.get(Employee.class, 1);
//            session.delete(emp);
            
            // пример 2
            session.createQuery("delete Employee where name = 'Elena'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

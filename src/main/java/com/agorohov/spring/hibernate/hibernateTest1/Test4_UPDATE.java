package com.agorohov.spring.hibernate.hibernateTest1;

import com.agorohov.spring.hibernate.hibernateTest1.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test4_UPDATE {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = (Employee) session.get(Employee.class, 1);
//            emp.setSalary(1000);

            session.createQuery("update Employee set salary = 1000 where name = 'Aleksandr'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

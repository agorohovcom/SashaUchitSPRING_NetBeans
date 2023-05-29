package com.agorohov.spring.hibernateTest;

import com.agorohov.spring.hibernateTest.entity.Employee1;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test3 {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee1.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // получение всех работников из БД
//            List<Employee> emps = session
//                    .createQuery("from Employee") // имя класса, а не таблицы
//                    .list();

            // получение всех работников из БД по имени Aleksandr
//            List<Employee> emps = session
//                    .createQuery("from Employee where name = 'Aleksandr'")  // name - название поля в Employee
//                    .list();
            
            // получение всех работников из БД по имени Aleksandr с ЗП выше 500
            List<Employee1> emps = session
                    .createQuery("from Employee where name = 'Aleksandr' AND salary > 500")  // name - название поля в Employee
                    .list();

            for (Employee1 e : emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done! =)");
        } finally {
            factory.close();
        }
    }
}

package com.agorohov.spring.hibernateTest2;

import com.agorohov.spring.hibernateTest2.entity.Detail;
import com.agorohov.spring.hibernateTest2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        
        try {
            // пример 1
            // добавляем employee 1
//            session = factory.getCurrentSession();
//            
//            Employee employee = new Employee("Zaur", "Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "123456789", "zaurtregulov@gmail.com");
//            employee.setEmpDetail(detail);
//            
//            session.beginTransaction();
//            session.save(employee);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 2
            // добавляем employee 2
            session = factory.getCurrentSession();
            
            Employee employee = new Employee(
                    "Oleg",
                    "Smirnov",
                    "sales",
                    700);
            Detail detail = new Detail(
                    "Moscow", 
                    "987654321", 
                    "olejka@gmail.com");
            employee.setEmpDetail(detail);
            
            session.beginTransaction();
            session.save(employee);
            
            session.getTransaction().commit();
            System.out.println("Done! =)");

            // пример 3
            // выводим детали employee 1 через каскад
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Employee emp = (Employee) session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail());
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            
            // пример 4
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Employee emp = (Employee) session.get(Employee.class, 3);
//            session.delete(emp);

            // через HQL запрос почему-то не удаляет каскадом
            // (остаётся запись в таблице details
//            session.createQuery("delete Detail where city = 'Moscow'")
//                    .executeUpdate();
            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
        } finally {
            factory.close();
            if(session.isOpen()){
                session.close();
            }
        }
    }
}
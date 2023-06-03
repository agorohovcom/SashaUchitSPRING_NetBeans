package com.agorohov.spring.hibernateTest2_OneToOne;

import com.agorohov.spring.hibernateTest2_OneToOne.entity.Detail;
import com.agorohov.spring.hibernateTest2_OneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test2_OneToOneBiDirection {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        
        try {
            // пример 1
            // добавление с Bi-directional
//            session = factory.getCurrentSession();
//            
//            Employee employee = new Employee(
//                    "Nikolay", 
//                    "Ivanov",
//                    "HR", 
//                    850);
//            Detail detail = new Detail(
//                    "New-York",
//                    "213785489",
//                    "nikolay111@gmail.com");
//            
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            
//            session.beginTransaction();
//            session.save(detail);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 2
            // получение информации из базы
//            session = factory.getCurrentSession();
//            
//            session.beginTransaction();
//            
//            Detail detail = (Detail) session.get(Detail.class, 6);
//            
//            System.out.println(detail.getEmployee());
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            
            // пример 3
            // удаление каскадом
//            session = factory.getCurrentSession();
//            
//            session.beginTransaction();
//            
//            Detail detail = (Detail) session.get(Detail.class, 6);
//            
//            session.delete(detail);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 4
            // удаляем Detail, оставляем Employee
            // удаление cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
            session = factory.getCurrentSession();
            
            session.beginTransaction();
            
            Detail detail = (Detail) session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            
            session.getTransaction().commit();
            System.out.println("Done! =)");
        } finally {
            factory.close();
            if(session.isOpen()){
                session.close();
            }
        }
    }
}
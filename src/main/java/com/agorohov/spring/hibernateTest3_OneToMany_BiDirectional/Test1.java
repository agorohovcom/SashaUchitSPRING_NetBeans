package com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional;

import com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        
        try {
            // пример 1
            // добавление департамента и двух работников
//            session = factory.getCurrentSession();
//            
//            Department dep = new Department("IT", 1200, 300);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//            
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            
//            session.beginTransaction();
//            session.save(dep);
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 2
            // получить департамент по id и вывести в консоль департамент и его работников
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Department department = (Department) session.get(Department.class, 1);
//            
//            System.out.println(department);
//            System.out.println(department.getEmps());
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 3
            // получить работника по id, вывести на экран работника и его департамент
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            Employee employee = (Employee) session.get(Employee.class, 3);
            
            System.out.println(employee);
            System.out.println(employee.getDepartment());
                    
            session.getTransaction().commit();
            System.out.println("Done! =)");

            // пример 4
            // === если cascade = CascadeType.ALL: ===
            // удаление работника повлечёт за сабой удаление департамента,
            // удаление департамента повлечёт за собой удаление всех связанных работников.
            // Чтобы не удалялись все связанные работкики, нужно использовать
            // cascade = {
            //          CascadeType.ALL,
            //          CascadeType.PERSIST,
            //          CascadeType.MERGE,
            //          CascadeType.REFRESH,
            //          CascadeType.DETACH}: ===
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Employee employee = (Employee) session.get(Employee.class, 4);
//                               
//            session.delete(employee);
//            
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
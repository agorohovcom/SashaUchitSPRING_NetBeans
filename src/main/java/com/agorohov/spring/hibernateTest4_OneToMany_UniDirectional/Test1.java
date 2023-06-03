package com.agorohov.spring.hibernateTest4_OneToMany_UniDirectional;

import com.agorohov.spring.hibernateTest4_OneToMany_UniDirectional.entity.*;
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
//            Department dep = new Department("HR", 1500, 500);
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
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
//            Department department = (Department) session.get(Department.class, 2);
//            
//            System.out.println(department);
//            System.out.println(department.getEmps());
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 3
            // получить работника по id и вывести на экран
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Employee employee = (Employee) session.get(Employee.class, 1);
//            
//            System.out.println(employee);
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 4
            // удаление работника не повлечёт за сабой удаление департамента.
            // === если cascade = CascadeType.ALL: ===            
            // удаление департамента повлечёт за собой удаление всех связанных работников.
            // чтобы не удалялись все связанные работкики, нужно использовать
            // cascade = {
            //          CascadeType.ALL,
            //          CascadeType.PERSIST,
            //          CascadeType.MERGE,
            //          CascadeType.REFRESH,
            //          CascadeType.DETACH}: ===
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            
//            Employee employee = (Employee) session.get(Employee.class, 4);
//            session.delete(employee);

//            Department department = (Department) session.get(Department.class, 3);
//            session.delete(department);
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
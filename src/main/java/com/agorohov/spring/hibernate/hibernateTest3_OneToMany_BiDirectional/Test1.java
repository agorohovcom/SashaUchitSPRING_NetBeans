package com.agorohov.spring.hibernate.hibernateTest3_OneToMany_BiDirectional;

import com.agorohov.spring.hibernate.hibernateTest3_OneToMany_BiDirectional.entity.Department;
import com.agorohov.spring.hibernate.hibernateTest3_OneToMany_BiDirectional.entity.Employee;
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
            // добавление департамента и 3 работников
//            session = factory.getCurrentSession();
//            
//            Department dep = new Department(
//                    "Sales", 
//                    1500, 
//                    800);
//            Employee emp1 = new Employee(
//                    "Zaur", 
//                    "Tregulov", 
//                    800);
//            Employee emp2 = new Employee(
//                    "Elena", 
//                    "Smirnova", 
//                    1500);
//            Employee emp3 = new Employee(
//                    "Anton", 
//                    "Sidorov", 
//                    1200);
//                       
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            
//            session.beginTransaction();
//            session.save(dep);
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

            // пример 2
            // получаем департамент и выводим работников
            // тестируем fetch = FetchType.LAZY и .EAGER
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            System.out.println("Get department");
            Department department = (Department) session.get(Department.class, 4);
            
            // если при типе загрузки "fetch = FetchType.LAZY)" запросить информацию
            // о сотрудниках (из связанной таблицы) после ".commit", получим ошибку,
            // так как сессия уже закрыта, а данные по связанным таблицам не загружены.
            // Чтобы избежать ошибки, можем перед коммитом подгрузить данные.
            // при использовании "fetch = FetchType.LAZY" всё будет норм и без подгрузки.
            System.out.println("Подгрузим наших работников перед закрытием сессии");
            department.getEmps().get(0);
            
            // закрываем сессию
            session.getTransaction().commit();
            
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show deployees of the department");
            System.out.println(department.getEmps());
                    
            
            System.out.println("Done! =)");

            // пример 3
            // получить работника по id, вывести на экран работника и его департамент
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            
//            Employee employee = (Employee) session.get(Employee.class, 3);
//            
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//                    
//            session.getTransaction().commit();
//            System.out.println("Done! =)");

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
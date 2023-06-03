package com.agorohov.spring.hibernate.hibernateTest5_ManyToMany;

import com.agorohov.spring.hibernate.hibernateTest5_ManyToMany.entity.Child;
import com.agorohov.spring.hibernate.hibernateTest5_ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        
        try{
            session = factory.getCurrentSession();
            
            Section section1 = new Section("Boxing");
            Child child1 = new Child("Sasha", 13);
            
            section1.addChildToSection(child1);
            
            session.beginTransaction();
            
            session.persist(section1);
              
            session.getTransaction().commit();
            System.out.println("Done! =)");
            // 1
            // добавляем 1 секцию, троих детей и добавляем детей в секцию
//            session = factory.getCurrentSession();
//            
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Olya", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavlik", 9);
//            
//            // если в Entity используем не "CascadeType.ALL",
//            // надо добавлять детей в секцию не перед, а
//            // после "beginTransaction()" и каждому делать "save()".
//            // Либо для каскадного сохранения вместо "save(section1)"
//            // использовать "persist(section1)"
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//            
//            session.beginTransaction();
//            
////            session.save(section1);
//            session.persist(section1);
//              
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
             // ********************************************
            
            // 2
            // создаём 3 секции и 1 ребенка,
            //добавляем ребёнку 3 секции
//            session = factory.getCurrentSession();
//            
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//
//            Child child1 = new Child("Ihor", 10);
//            
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//            
//            session.beginTransaction();
//            
//            session.save(child1);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            // ********************************************
            
            // 3
            // получаем секцию по id, выводим инфо о ней и участниках
//            session = factory.getCurrentSession();
//            
//            session.beginTransaction();
//            
//            Section section = (Section) session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            // ********************************************
            
            // 4
            // получаем ребенка по id, выводим инфо о нём и его секциях
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            
//            Child child = (Child) session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            // ********************************************
            
            // 5
            // удаляем секцию по id
            // при использовании в Entity "CascadeType.ALL"
            //удаляются все дети, связанные с секцией
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            
//            Section section = (Section) session.get(Section.class, 7);
//            session.delete(section);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            // ********************************************
            
            // 6
            // удаляем ребенка по id
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            
//            Child child = (Child) session.get(Child.class, 5);
//            session.delete(child);
//            
//            session.getTransaction().commit();
//            System.out.println("Done! =)");
            // ********************************************
        }finally{
            if(session.isOpen()){
                session.close();
            }
            factory.close();
        }
    }
    
}

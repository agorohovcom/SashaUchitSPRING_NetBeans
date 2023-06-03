package com.agorohov.spring.hibernateTest5_ManyToMany.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="children")
public class Child {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String firstName;
    
    @Column(name="age")
    private int age;
    
//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="child_section",
            joinColumns = @JoinColumn(name="child_id"),
            inverseJoinColumns = @JoinColumn(name="section_id"))
    private List<Section> sections;

    public Child() {
    }

    public Child(String name, int age) {
        this.firstName = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" + "id=" + id + ", firstName=" + firstName + ", age=" + age + '}';
    }
    
    public void addSectionToChild(Section section){
        if(sections == null){
            sections = new ArrayList<>();
        }
        sections.add(section);
    }
    
}

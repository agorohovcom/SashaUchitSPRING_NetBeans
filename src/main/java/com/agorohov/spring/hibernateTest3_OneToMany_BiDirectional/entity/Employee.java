package com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional.entity;

import com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional.*;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String firstName;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="salary")
    private int salary;
    
    @ManyToOne(cascade = {
//        CascadeType.ALL,
        // всё кроме REMOVE
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.DETACH})
    @JoinColumn(name="department_id") // foreign key
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.firstName = name;
        this.surname = surname;
        this.salary = salary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", salary=" + salary + '}';
    }
    
    
}

package com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional.entity;

import com.agorohov.spring.hibernateTest3_OneToMany_BiDirectional.entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String depatmentName;
    @Column(name="max_salary")
    private int maxSalary;
    @Column(name="min_salary")
    private int minSalary;
    
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department", 
            fetch = FetchType.LAZY)
    private List<Employee> emps;

    public Department() {
    }

    public Department(String depatmentName, int maxSalary, int minSalary) {
        this.depatmentName = depatmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }
    
    public void addEmployeeToDepartment(Employee employee){
        if(emps==null){
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDepartment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", depatmentName=" + depatmentName + ", maxSalary=" + maxSalary + ", minSalary=" + minSalary + '}';
    }
    
    
}

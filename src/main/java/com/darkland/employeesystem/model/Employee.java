package com.darkland.employeesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<DepartmentEmployee> departmentsEmployees = new ArrayList<>();

    public Employee() {
    }
    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee)
    {
        departmentsEmployees.add(departmentEmployee);
        departmentEmployee.setEmployee(this);
    }
}

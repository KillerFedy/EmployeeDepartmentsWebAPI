package com.darkland.employeesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;
    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<DepartmentEmployee> departmentsEmployees = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "parentDepartment")
    private List<Department> childDepartments = new ArrayList<>();
    @ManyToOne
    private Department parentDepartment;

    public Department() {
    }
    public void addChildDepartment(Department department)
    {
        childDepartments.add(department);
        department.setParentDepartment(this);
    }
    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee)
    {
        departmentsEmployees.add(departmentEmployee);
        departmentEmployee.setDepartment(this);
    }
}

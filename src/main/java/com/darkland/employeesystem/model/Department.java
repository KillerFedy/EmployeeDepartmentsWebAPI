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
    @JoinColumn(name = "parentDepartment_id")
    private Department parentDepartment;

    public Department() {
    }
}

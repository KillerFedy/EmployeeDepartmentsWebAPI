package com.darkland.employeesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<DepartmentEmployee> departmentsEmployees = new ArrayList<>();
    @OneToMany(mappedBy = "parentDepartment")
    private List<Department> childDepartments = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "parentDepartment_id")
    private Department parentDepartment;

    public Department() {
    }
}

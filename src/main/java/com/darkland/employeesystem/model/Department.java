package com.darkland.employeesystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

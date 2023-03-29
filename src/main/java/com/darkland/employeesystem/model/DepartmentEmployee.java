package com.darkland.employeesystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "departments_employees")
public class DepartmentEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "depatment_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String employeePosition;

    public DepartmentEmployee() {
    }

}

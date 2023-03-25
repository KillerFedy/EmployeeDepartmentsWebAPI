package com.darkland.employeesystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "departments_employees")
public class DepartmentEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

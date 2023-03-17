package com.darkland.employeesystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

    public DepartmentEmployee(Employee employee, Department department, String employeePosition)
    {
        employee.addDepartmentEmployee(this);
        department.addDepartmentEmployee(this);
        this.setEmployeePosition(employeePosition);
    }
}

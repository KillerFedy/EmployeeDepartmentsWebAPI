package com.darkland.employeesystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private Integer id;
    private String departmentName;
    private List<DepartmentDto> childDepartments;
    private List<EmployeeDto> employees;
}

package com.darkland.employeesystem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentDto {
    private Integer id;
    private String departmentName;
    private List<DepartmentDto> childDepartments = new ArrayList<>();
    private List<EmployeeDto> employees = new ArrayList<>();
}

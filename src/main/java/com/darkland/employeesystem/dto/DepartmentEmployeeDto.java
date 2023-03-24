package com.darkland.employeesystem.dto;

import lombok.Data;

@Data
public class DepartmentEmployeeDto {
    private Integer departmentId;
    private Integer employeeId;
    private String employeePosition;

    public DepartmentEmployeeDto(Integer departmentId, Integer employeeId, String employeePosition) {
        this.departmentId = departmentId;
        this.employeeId = employeeId;
        this.employeePosition = employeePosition;
    }
}

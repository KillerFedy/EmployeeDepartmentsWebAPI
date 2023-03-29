package com.darkland.employeesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentEmployeeDto {
    private Integer departmentId;
    private Integer employeeId;
    private String employeePosition;
}

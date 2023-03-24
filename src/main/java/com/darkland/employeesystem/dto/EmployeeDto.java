package com.darkland.employeesystem.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Integer id;
    private String employeeName;

    public EmployeeDto(Integer id, String employeeName) {
        this.id = id;
        this.employeeName = employeeName;
    }
}

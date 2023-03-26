package com.darkland.employeesystem.dto;

import lombok.Data;

@Data
public class EmployeeSavedDto {
    private Integer id;
    private String employeeName;

    public EmployeeSavedDto(Integer id, String employeeName) {
        this.id = id;
        this.employeeName = employeeName;
    }
}

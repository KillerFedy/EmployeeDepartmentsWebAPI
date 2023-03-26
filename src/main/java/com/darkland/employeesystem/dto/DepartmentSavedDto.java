package com.darkland.employeesystem.dto;

import lombok.Data;

@Data
public class DepartmentSavedDto {
    private Integer id;
    private String departmentName;
    private Integer parentDepartmentId = -1;

    public DepartmentSavedDto(Integer id, String departmentName, Integer parentDepartmentId) {
        this.id = id;
        this.departmentName = departmentName;
        this.parentDepartmentId = parentDepartmentId;
    }

    public DepartmentSavedDto(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}

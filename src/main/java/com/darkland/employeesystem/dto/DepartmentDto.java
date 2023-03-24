package com.darkland.employeesystem.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Integer id;
    private String departmentName;
    private Integer parentDepartmentId = -1;

    public DepartmentDto(Integer id, String departmentName, Integer parentDepartmentId) {
        this.id = id;
        this.departmentName = departmentName;
        this.parentDepartmentId = parentDepartmentId;
    }

    public DepartmentDto(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}

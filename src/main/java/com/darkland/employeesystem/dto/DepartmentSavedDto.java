package com.darkland.employeesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentSavedDto {
    private Integer id;
    private String departmentName;
    private Integer parentDepartmentId = -1;

    public DepartmentSavedDto(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}

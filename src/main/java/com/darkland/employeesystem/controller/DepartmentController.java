package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.DepartmentCreateDto;
import com.darkland.employeesystem.dto.DepartmentSavedDto;
import com.darkland.employeesystem.dto.DepartmentEmployeeDto;
import com.darkland.employeesystem.dto.EmployeePositionDto;
import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentSavedDto saveDepartment(@RequestBody DepartmentCreateDto departmentCreateDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department);
        DepartmentSavedDto departmentDto = new DepartmentSavedDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName());
        return departmentDto;
    }

    @PostMapping("/{depId}")
    public DepartmentSavedDto saveDepartment(@PathVariable Integer depId,
                                                     @RequestBody DepartmentCreateDto departmentCreateDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department, depId);
        DepartmentSavedDto departmentDto = new DepartmentSavedDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName(), depId);
        return departmentDto;
    }

    @PutMapping("/{depId}/employee/{empId}")
    public DepartmentEmployeeDto setEmployee(@PathVariable Integer depId, @PathVariable Integer empId,
                                                             @RequestBody EmployeePositionDto position)
    {
        DepartmentEmployee departmentEmployee = departmentService.setEmployee(depId, empId,
                position.getEmployeePosition());
        DepartmentEmployeeDto departmentEmployeeDto = new DepartmentEmployeeDto(depId, empId,
                departmentEmployee.getEmployeePosition());
        return departmentEmployeeDto;
    }
}

package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.DepartmentCreateDto;
import com.darkland.employeesystem.dto.DepartmentDto;
import com.darkland.employeesystem.dto.DepartmentEmployeeDto;
import com.darkland.employeesystem.dto.EmployeePositionDto;
import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentDto saveDepartment(@RequestBody DepartmentCreateDto departmentCreateDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department);
        DepartmentDto departmentDto = new DepartmentDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName());
        return departmentDto;
    }

    @PostMapping("/{depId}")
    public DepartmentDto saveDepartment(@PathVariable Integer depId,
                                                     @RequestBody DepartmentCreateDto departmentCreateDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department, depId);
        DepartmentDto departmentDto = new DepartmentDto(savedDepartment.getId(),
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

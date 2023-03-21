package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.DepartmentCreateDto;
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

    @PostMapping("/department")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentCreateDto departmentDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    @PostMapping("/{depId}/department")
    public ResponseEntity<Department> saveDepartment(@PathVariable Integer depId,
                                                     @RequestBody DepartmentCreateDto departmentDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department, depId);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    @PutMapping("/{depId}/employee/{empId}")
    public ResponseEntity<DepartmentEmployee> setEmployee(@PathVariable Integer depId, @PathVariable Integer empId,
                                          @RequestBody EmployeePositionDto position)
    {
        DepartmentEmployee departmentEmployee = departmentService.setEmployee(depId, empId,
                position.getEmployeePosition());
        return new ResponseEntity<>(departmentEmployee, HttpStatus.OK);
    }
}

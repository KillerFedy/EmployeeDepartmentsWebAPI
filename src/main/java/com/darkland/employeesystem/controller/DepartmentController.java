package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.DepartmentCreateDto;
import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/newDepartment")
    public Department saveDepartment(@RequestBody DepartmentCreateDto departmentDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/{depId}/newDepartment")
    public Department saveDepartmentWithParent(@PathVariable Integer depId, @RequestBody DepartmentCreateDto departmentDto)
    {
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        return departmentService.saveDepartment(department, depId);
    }

    @PutMapping("/{depId}/newEmployee/{empId}")
    public DepartmentEmployee setEmployee(@PathVariable Integer depId, @PathVariable Integer empId,
                                          @RequestBody String position)
    {
        return  departmentService.setEmployee(depId, empId, position);
    }
}

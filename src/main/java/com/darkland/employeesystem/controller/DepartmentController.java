package com.darkland.employeesystem.controller;

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

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/{depId}/saveDepartment")
    public Department saveDepartmentWithParent(@PathVariable Integer depId, @RequestBody Department department)
    {
        return departmentService.saveDepartment(department, depId);
    }

    @PutMapping("/{depId}/setEmployee/{empId}")
    public DepartmentEmployee setEmployee(@PathVariable Integer depId, @PathVariable Integer empId,
                                          @RequestBody String position)
    {
        return  departmentService.setEmployee(depId, empId, position);
    }
}

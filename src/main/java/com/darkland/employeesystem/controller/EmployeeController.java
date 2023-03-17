package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }
}

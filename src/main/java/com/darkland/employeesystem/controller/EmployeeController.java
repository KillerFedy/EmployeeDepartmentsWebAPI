package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.EmployeeCreateDto;
import com.darkland.employeesystem.dto.EmployeeSavedDto;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeSavedDto saveEmployee(@RequestBody EmployeeCreateDto employeeCreateDto)
    {
        Employee employee = new Employee();
        employee.setName(employeeCreateDto.getEmployeeName());
        var savedEmployee = employeeService.saveEmployee(employee);
        EmployeeSavedDto employeeDto = new EmployeeSavedDto(savedEmployee.getId(), savedEmployee.getName());
        return employeeDto;
    }
}

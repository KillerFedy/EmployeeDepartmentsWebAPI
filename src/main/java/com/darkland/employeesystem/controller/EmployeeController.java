package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.EmployeeCreateDto;
import com.darkland.employeesystem.dto.EmployeeDto;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeCreateDto employeeCreateDto)
    {
        Employee employee = new Employee();
        employee.setName(employeeCreateDto.getEmployeeName());
        var savedEmployee = employeeService.saveEmployee(employee);
        EmployeeDto employeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getName());
        return employeeDto;
    }
}

package com.darkland.employeesystem.service;

import com.darkland.employeesystem.dto.EmployeeDto;
import com.darkland.employeesystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<EmployeeDto> getEmployeesDtoByDepartmentId(Integer departmentId);
}

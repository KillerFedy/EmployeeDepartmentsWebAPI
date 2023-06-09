package com.darkland.employeesystem.service;

import com.darkland.employeesystem.dto.EmployeeDto;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.repository.DepartmentEmployeeRepository;
import com.darkland.employeesystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesDtoByDepartmentId(Integer departmentId) {
        List<DepartmentEmployee> departmentEmployees = departmentEmployeeRepository.findByDepartmentId(departmentId);
        return departmentEmployees.stream()
                .map(departmentEmployee -> {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setId(departmentEmployee.getEmployee().getId());
                    employeeDto.setName(departmentEmployee.getEmployee().getName());
                    employeeDto.setPosition(departmentEmployee.getEmployeePosition());
                    return employeeDto;
                })
                .collect(Collectors.toList());
    }
}

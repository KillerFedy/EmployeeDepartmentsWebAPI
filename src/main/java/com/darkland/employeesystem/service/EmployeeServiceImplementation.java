package com.darkland.employeesystem.service;

import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

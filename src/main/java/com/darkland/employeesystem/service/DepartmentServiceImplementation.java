package com.darkland.employeesystem.service;

import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.repository.DepartmentEmployeeRepository;
import com.darkland.employeesystem.repository.DepartmentRepository;
import com.darkland.employeesystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department saveDepartment(Department department, Integer parentId) {
        Department parentDepartment = departmentRepository.getReferenceById(parentId);
        parentDepartment.addChildDepartment(department);
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentEmployee setEmployee(Integer depId, Integer empId, String empPosition) {
        Employee employee = employeeRepository.getReferenceById(empId);
        Department department = departmentRepository.getReferenceById(depId);
        DepartmentEmployee departmentEmployee = new DepartmentEmployee(employee, department, empPosition);
        departmentRepository.save(department);
        employeeRepository.save(employee);
        return departmentEmployeeRepository.save(departmentEmployee);
    }
}

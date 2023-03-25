package com.darkland.employeesystem.service;

import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.repository.DepartmentEmployeeRepository;
import com.darkland.employeesystem.repository.DepartmentRepository;
import com.darkland.employeesystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
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
        Department parentDepartment = departmentRepository.findById(parentId).orElseThrow(
                () -> new NoSuchElementException("Отдел не найден"));
        parentDepartment.getChildDepartments().add(department);
        department.setParentDepartment(parentDepartment);
        departmentRepository.save(parentDepartment);
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentEmployee setEmployee(Integer depId, Integer empId, String empPosition) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new NoSuchElementException("Сотрудник не найден"));
        Department department = departmentRepository.findById(depId).orElseThrow(
                () -> new NoSuchElementException("Отдел не найден"));
        DepartmentEmployee departmentEmployee = new DepartmentEmployee();
        employee.getDepartmentsEmployees().add(departmentEmployee);
        departmentEmployee.setEmployee(employee);
        department.getDepartmentsEmployees().add(departmentEmployee);
        departmentEmployee.setDepartment(department);
        departmentEmployee.setEmployeePosition(empPosition);
        departmentRepository.save(department);
        employeeRepository.save(employee);
        return departmentEmployeeRepository.save(departmentEmployee);
    }
}

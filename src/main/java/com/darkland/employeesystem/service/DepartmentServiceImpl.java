package com.darkland.employeesystem.service;

import com.darkland.employeesystem.dto.DepartmentDto;
import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.model.Employee;
import com.darkland.employeesystem.repository.DepartmentEmployeeRepository;
import com.darkland.employeesystem.repository.DepartmentRepository;
import com.darkland.employeesystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    @Override
    public Department saveDepartment(Department department, Integer parentId) {
        Department parentDepartment = departmentRepository.findById(parentId).orElseThrow(
                () -> new NoSuchElementException("Отдел не найден"));
        parentDepartment.getChildDepartments().add(department);
        department.setParentDepartment(parentDepartment);
        departmentRepository.save(parentDepartment);
        return departmentRepository.save(department);
    }

    @Transactional
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

    @Override
    public List<DepartmentDto> getAllTopLevelDepartments() {
        List<Department> topDepartments = departmentRepository.findAllByParentDepartmentIsNull();
        if(topDepartments.size() == 0)
        {
            throw new NoSuchElementException("Отделы не найдены");
        }
        List<DepartmentDto> departmentDtos = SerializeDepartmentToDepartmentDto(topDepartments);
        return departmentDtos;
    }

    @Override
    public List<DepartmentDto> getDepartmentsByParentDepartmentId(Integer parentId) {
        List<Department> childDepartments = departmentRepository.findById(parentId).orElseThrow(
                () -> new NoSuchElementException("Отдел не найден")
        ).getChildDepartments();
        List<DepartmentDto> departmentDtos = SerializeDepartmentToDepartmentDto(childDepartments);
        return departmentDtos;
    }

    private List<DepartmentDto> SerializeDepartmentToDepartmentDto(List<Department> departments)
    {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for(Department department : departments)
        {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setId(department.getId());
            departmentDto.setDepartmentName(department.getDepartmentName());
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }
}

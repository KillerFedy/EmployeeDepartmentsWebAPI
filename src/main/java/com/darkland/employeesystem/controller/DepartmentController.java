package com.darkland.employeesystem.controller;

import com.darkland.employeesystem.dto.*;
import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.service.DepartmentService;
import com.darkland.employeesystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081/")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @PostMapping
    public DepartmentSavedDto saveDepartment(@RequestBody DepartmentCreateDto departmentCreateDto)
    {
        if(departmentCreateDto == null || departmentCreateDto.getDepartmentName().equals(""))
        {
            throw new IllegalArgumentException("Некорректное именование отдела");
        }
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department);
        DepartmentSavedDto departmentDto = new DepartmentSavedDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName());
        return departmentDto;
    }

    @PostMapping("/{depId}")
    public DepartmentSavedDto saveDepartment(@PathVariable Integer depId,
                                                     @RequestBody DepartmentCreateDto departmentCreateDto)
    {
        if(departmentCreateDto == null || departmentCreateDto.getDepartmentName().equals(""))
        {
            throw new IllegalArgumentException("Некорректное именование отдела");
        }
        Department department = new Department();
        department.setDepartmentName(departmentCreateDto.getDepartmentName());
        Department savedDepartment = departmentService.saveDepartment(department, depId);
        DepartmentSavedDto departmentDto = new DepartmentSavedDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName(), depId);
        return departmentDto;
    }

    @PutMapping("/{depId}/employee/{empId}")
    public DepartmentEmployeeDto setEmployee(@PathVariable Integer depId, @PathVariable Integer empId,
                                                             @RequestBody EmployeePositionDto position)
    {
        if(position == null || position.getEmployeePosition().equals(""))
        {
            throw new IllegalArgumentException("Некорректный ввод должности сотрудника");
        }
        DepartmentEmployee departmentEmployee = departmentService.setEmployee(depId, empId,
                position.getEmployeePosition());
        DepartmentEmployeeDto departmentEmployeeDto = new DepartmentEmployeeDto(depId, empId,
                departmentEmployee.getEmployeePosition());
        return departmentEmployeeDto;
    }

    @GetMapping
    public List<DepartmentDto> getAllHierarchy()
    {
        System.out.println("Запрос на иерархию");
        List<DepartmentDto> topDepartments = departmentService.getAllTopLevelDepartments();
        fillHierarchy(topDepartments);
        System.out.println("Иерархия заполнена успешно");
        return topDepartments;
    }

    private void fillHierarchy(List<DepartmentDto> departments)
    {
        if(departments.size() == 0)
        {
            return;
        }
        for(DepartmentDto departmentDto: departments)
        {
            List<EmployeeDto> employeeDtos = employeeService.getEmployeesDtoByDepartmentId(departmentDto.getId());
            List<DepartmentDto> childDepartmentDtos = departmentService.getDepartmentsByParentDepartmentId(departmentDto.getId());
            departmentDto.setEmployees(employeeDtos);
            fillHierarchy(childDepartmentDtos);
            departmentDto.setChildDepartments(childDepartmentDtos);
        }
    }
}

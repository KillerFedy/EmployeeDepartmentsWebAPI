package com.darkland.employeesystem.service;

import com.darkland.employeesystem.model.Department;
import com.darkland.employeesystem.model.DepartmentEmployee;
import com.darkland.employeesystem.model.Employee;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public Department saveDepartment(Department department, Integer parentId);

    public DepartmentEmployee setEmployee(Integer depId, Integer empId, String empPosition);
}

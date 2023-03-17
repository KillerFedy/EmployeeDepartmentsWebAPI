package com.darkland.employeesystem.repository;

import com.darkland.employeesystem.model.DepartmentEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Integer> {
}

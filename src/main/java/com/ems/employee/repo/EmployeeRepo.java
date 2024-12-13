package com.ems.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employee.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}

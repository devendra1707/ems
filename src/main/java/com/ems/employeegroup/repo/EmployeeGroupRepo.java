package com.ems.employeegroup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employeegroup.model.EmployeeGroup;

public interface EmployeeGroupRepo extends JpaRepository<EmployeeGroup, Integer> {

}

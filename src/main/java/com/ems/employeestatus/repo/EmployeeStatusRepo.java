package com.ems.employeestatus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employeestatus.model.EmployeeStatus;

public interface EmployeeStatusRepo extends JpaRepository<EmployeeStatus, Integer>{

}

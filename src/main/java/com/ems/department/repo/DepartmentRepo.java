package com.ems.department.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.department.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}

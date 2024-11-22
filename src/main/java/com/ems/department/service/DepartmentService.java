package com.ems.department.service;

import java.util.List;

import com.ems.department.model.Department;

public interface DepartmentService {

	public Department createDepartment(Department department);

	public Department updateDepartment(int departmentId, Department department);

	public Department getDepartment(int departmentId);

	public List<Department> departmentList();

	public void deleteDepartment(int departmentId);

}

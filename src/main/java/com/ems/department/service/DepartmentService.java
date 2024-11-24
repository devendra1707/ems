package com.ems.department.service;

import java.util.List;

import com.ems.department.payload.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto createDepartment(DepartmentDto departmentDto);

	public DepartmentDto updateDepartment(int departmentId, DepartmentDto departmentDto);

	public DepartmentDto getDepartment(int departmentId);

	public List<DepartmentDto> departmentList();

	public void deleteDepartment(int departmentId);

}

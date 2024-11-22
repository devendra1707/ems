package com.ems.department.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.department.exception.DepartmentNotFoundException;
import com.ems.department.model.Department;
import com.ems.department.repo.DepartmentRepo;
import com.ems.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepo departmentRepo;

	public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}
	
	@Override
	public Department createDepartment(Department department) {
		Department createDepartment = departmentRepo.save(department);
		return createDepartment;
	}

	@Override
	public Department updateDepartment(int departmentId, Department department) {
		Department getDepartment = departmentRepo.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
		if (getDepartment != null) {
			getDepartment.setTitle(department.getTitle());
			departmentRepo.save(getDepartment);
		}

		return getDepartment;
	}

	@Override
	public Department getDepartment(int departmentId) {

		Department getDepartment = departmentRepo.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
		return getDepartment;
	}

	@Override
	public List<Department> departmentList() {
		List<Department> departmentList = departmentRepo.findAll();
		return departmentList;
	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentRepo.deleteById(departmentId);
	}


}

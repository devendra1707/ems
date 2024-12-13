package com.ems.department.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.department.exception.DepartmentNotFoundException;
import com.ems.department.model.Department;
import com.ems.department.payload.DepartmentDto;
import com.ems.department.repo.DepartmentRepo;
import com.ems.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo departmentRepo;
	private ModelMapper modelMapper;

	public DepartmentServiceImpl(DepartmentRepo departmentRepo, ModelMapper modelMapper) {
		this.departmentRepo = departmentRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department createDepartment = modelMapper.map(departmentDto, Department.class);
		Department saveDepartment = departmentRepo.save(createDepartment);
		return modelMapper.map(saveDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto updateDepartment(int departmentId, DepartmentDto departmentDto) {
		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));

		department.setTitle(departmentDto.getTitle());
		Department updaDepartment = departmentRepo.save(department);

		return modelMapper.map(updaDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartment(int departmentId) {

		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> departmentList() {
		List<Department> departmentList = departmentRepo.findAll();
		List<DepartmentDto> departmentDtos = departmentList.stream()
				.map(dept -> modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
		return departmentDtos;
	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentRepo.deleteById(departmentId);
	}

}

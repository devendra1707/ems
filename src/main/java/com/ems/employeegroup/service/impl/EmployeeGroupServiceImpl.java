package com.ems.employeegroup.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.employeegroup.exception.EmployeeGroupNotFoundException;
import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeegroup.payload.EmployeeGroupDto;
import com.ems.employeegroup.repo.EmployeeGroupRepo;
import com.ems.employeegroup.service.EmployeeGroupService;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {
	private EmployeeGroupRepo employeeGroupRepo;
	private ModelMapper modelMapper;

	public EmployeeGroupServiceImpl(EmployeeGroupRepo employeeGroupRepo, ModelMapper modelMapper) {
		this.employeeGroupRepo = employeeGroupRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeGroupDto createEmployeeGroup(EmployeeGroupDto employeeGroupDto) {
		EmployeeGroup createEmployeeGroup = modelMapper.map(employeeGroupDto, EmployeeGroup.class);
		EmployeeGroup saveEmployeeGroup = employeeGroupRepo.save(createEmployeeGroup);
		return modelMapper.map(saveEmployeeGroup, EmployeeGroupDto.class);
	}

	@Override
	public EmployeeGroupDto updateEmployeeGroup(int employeeGroupId, EmployeeGroupDto employeeGroupDto) {
		EmployeeGroup employeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));
		employeeGroup.setTitle(employeeGroupDto.getTitle());
		EmployeeGroup updateEmployeeGroup = employeeGroupRepo.save(employeeGroup);

		return modelMapper.map(updateEmployeeGroup, EmployeeGroupDto.class);
	}

	@Override
	public EmployeeGroupDto getEmployeeGroup(int employeeGroupId) {

		EmployeeGroup getEmployeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));
		return modelMapper.map(getEmployeeGroup, EmployeeGroupDto.class);
	}

	@Override
	public List<EmployeeGroupDto> employeeGroupList() {
		List<EmployeeGroup> employeeGroupList = employeeGroupRepo.findAll();
		List<EmployeeGroupDto> dtos = employeeGroupList.stream()
				.map(emp -> modelMapper.map(emp, EmployeeGroupDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public void deleteEmployeeGroup(int employeeGroupId) {
		employeeGroupRepo.deleteById(employeeGroupId);
	}
}

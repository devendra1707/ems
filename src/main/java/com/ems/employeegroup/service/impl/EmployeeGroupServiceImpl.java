package com.ems.employeegroup.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.employeegroup.exception.EmployeeGroupNotFoundException;
import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeegroup.repo.EmployeeGroupRepo;
import com.ems.employeegroup.service.EmployeeGroupService;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {
	private EmployeeGroupRepo employeeGroupRepo;

	public EmployeeGroupServiceImpl(EmployeeGroupRepo employeeGroupRepo) {
		this.employeeGroupRepo = employeeGroupRepo;
	}

	@Override
	public EmployeeGroup createEmployeeGroup(EmployeeGroup employeeGroup) {
		EmployeeGroup createEmployeeGroup = employeeGroupRepo.save(employeeGroup);
		return createEmployeeGroup;
	}

	@Override
	public EmployeeGroup updateEmployeeGroup(int employeeGroupId, EmployeeGroup employeeGroup) {
		EmployeeGroup getEmployeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));
		if (getEmployeeGroup != null) {
			getEmployeeGroup.setTitle(employeeGroup.getTitle());
			employeeGroupRepo.save(getEmployeeGroup);
		}

		return getEmployeeGroup;
	}

	@Override
	public EmployeeGroup getEmployeeGroup(int employeeGroupId) {

		EmployeeGroup getEmployeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));
		return getEmployeeGroup;
	}

	@Override
	public List<EmployeeGroup> employeeGroupList() {
		List<EmployeeGroup> employeeGroupList = employeeGroupRepo.findAll();
		return employeeGroupList;
	}

	@Override
	public void deleteEmployeeGroup(int employeeGroupId) {
		employeeGroupRepo.deleteById(employeeGroupId);
	}
}

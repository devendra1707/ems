package com.ems.employeestatus.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.employeestatus.exception.EmployeeStatusNotFoundException;
import com.ems.employeestatus.model.EmployeeStatus;
import com.ems.employeestatus.repo.EmployeeStatusRepo;
import com.ems.employeestatus.service.EmployeeStatusService;

@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService {
	private EmployeeStatusRepo employeeStatusRepo;

	public EmployeeStatusServiceImpl(EmployeeStatusRepo employeeStatusRepo) {
		this.employeeStatusRepo = employeeStatusRepo;
	}

	@Override
	public EmployeeStatus createEmployeeStatus(EmployeeStatus employeeStatus) {
		EmployeeStatus createEmployeeStatus = employeeStatusRepo.save(employeeStatus);
		return createEmployeeStatus;
	}

	@Override
	public EmployeeStatus updateEmployeeStatus(int employeeStatusId, EmployeeStatus employeeStatus) {
		EmployeeStatus getEmployeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));
		if (getEmployeeStatus != null) {
			getEmployeeStatus.setTitle(employeeStatus.getTitle());
			employeeStatusRepo.save(getEmployeeStatus);
		}

		return getEmployeeStatus;
	}

	@Override
	public EmployeeStatus getEmployeeStatus(int employeeStatusId) {

		EmployeeStatus getEmployeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));
		return getEmployeeStatus;
	}

	@Override
	public List<EmployeeStatus> employeeStatusList() {
		List<EmployeeStatus> employeeStatusList = employeeStatusRepo.findAll();
		return employeeStatusList;
	}

	@Override
	public void deleteEmployeeStatus(int employeeStatusId) {
		employeeStatusRepo.deleteById(employeeStatusId);
	}
}

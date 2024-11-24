package com.ems.employeestatus.service;

import java.util.List;

import com.ems.employeestatus.payload.EmployeeStatusDto;

public interface EmployeeStatusService {
	public EmployeeStatusDto createEmployeeStatus(EmployeeStatusDto employeeStatusDto);

	public EmployeeStatusDto updateEmployeeStatus(int employeeStatusId, EmployeeStatusDto employeeStatusDto);

	public EmployeeStatusDto getEmployeeStatus(int employeeStatusId);

	public List<EmployeeStatusDto> employeeStatusList();

	public void deleteEmployeeStatus(int employeeStatusId);
}

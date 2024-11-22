package com.ems.employeestatus.service;

import java.util.List;

import com.ems.employeestatus.model.EmployeeStatus;

public interface EmployeeStatusService {
	public EmployeeStatus createEmployeeStatus(EmployeeStatus employeeStatus);

	public EmployeeStatus updateEmployeeStatus(int employeeStatusId, EmployeeStatus employeeStatus);

	public EmployeeStatus getEmployeeStatus(int employeeStatusId);

	public List<EmployeeStatus> employeeStatusList();

	public void deleteEmployeeStatus(int employeeStatusId);
}

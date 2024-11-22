package com.ems.employeegroup.service;

import java.util.List;

import com.ems.employeegroup.model.EmployeeGroup;

public interface EmployeeGroupService {

	public EmployeeGroup createEmployeeGroup(EmployeeGroup employeeGroup);

	public EmployeeGroup updateEmployeeGroup(int employeeGroupId, EmployeeGroup employeeGroup);

	public EmployeeGroup getEmployeeGroup(int employeeGroupId);

	public List<EmployeeGroup> employeeGroupList();

	public void deleteEmployeeGroup(int employeeGroupId);

}

package com.ems.employeegroup.service;

import java.util.List;

import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeegroup.payload.EmployeeGroupDto;

public interface EmployeeGroupService {

	public EmployeeGroupDto createEmployeeGroup(EmployeeGroupDto employeeGroupDto);

	public EmployeeGroupDto updateEmployeeGroup(int employeeGroupId, EmployeeGroupDto employeeGroupDto);

	public EmployeeGroupDto getEmployeeGroup(int employeeGroupId);

	public List<EmployeeGroupDto> employeeGroupList();

	public void deleteEmployeeGroup(int employeeGroupId);

}

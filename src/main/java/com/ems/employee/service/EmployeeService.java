package com.ems.employee.service;

import java.util.List;

import com.ems.employee.payload.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto createEmployee(EmployeeDto employeeDto,
			int staffCategoryId, 
			int genderId,
			int departmentId,
			int regionId,
			int adgId,
			int zoneId, 
			int circleId, 
			int divisionId,
			int employeeGroupId, 
			int designationId,
			int postHeldId,
			int cadreId, 
			int specialisationId,
			int reservationClasificationId,
			int stationId,
			int employeeStatusId, 
			int payScaleId

	);

	public EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto, int staffCategoryId, int genderId, int departmentId,
			int regionId, int adgId, int zoneId, int circleId, int divisionId, int employeeGroupId, int designationId,
			int reservationClasificationId,int postHeldId, int cadreId, int specialisationId, int stationId, int employeeStatusId, int payScaleId);

	public EmployeeDto getEmployee(int employeeId);

	public List<EmployeeDto> employeeList();

	public void deleteEmployee(int employeeId);
}

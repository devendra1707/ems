package com.ems.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.employee.payload.EmployeeDto;
import com.ems.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Create Employee
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee,
			@RequestParam int staffCategoryId,
			@RequestParam int genderId,
			@RequestParam int departmentId,
			@RequestParam int regionId,
			@RequestParam int adgId,
			@RequestParam int zoneId,
			@RequestParam int circleId,
			@RequestParam int divisionId, 
			@RequestParam int employeeGroupId, 
			@RequestParam int designationId,
			@RequestParam int postHeldId, 
			@RequestParam int cadreId, 
			@RequestParam int specialisationId,
			@RequestParam int reservationClasificationId,
//			@RequestParam(required = false) Integer stationId,
//	        @RequestParam(required = false) Integer employeeStatusId,
			@RequestParam int stationId,
			@RequestParam int employeeStatusId, 
			@RequestParam() int payScaleId) {

		EmployeeDto createEmployee = employeeService.createEmployee(employee, staffCategoryId, genderId, departmentId, regionId, adgId, zoneId, circleId, divisionId, employeeGroupId, designationId, postHeldId, cadreId, specialisationId, reservationClasificationId, stationId, employeeStatusId, payScaleId);

		return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);
	}

	// update Employee
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employeeId") int employeeId,
			@RequestBody EmployeeDto employee,
			@RequestParam int staffCategoryId,
			@RequestParam int genderId,
			@RequestParam int departmentId,
			@RequestParam int regionId,
			@RequestParam int adgId,
			@RequestParam int zoneId,
			@RequestParam int circleId,
			@RequestParam int divisionId, 
			@RequestParam int employeeGroupId, 
			@RequestParam int designationId,
			@RequestParam int postHeldId, 
			@RequestParam int cadreId, 
			@RequestParam int specialisationId,
			@RequestParam int reservationClasificationId,
			@RequestParam int stationId,
			@RequestParam int employeeStatusId, 
			@RequestParam int payScaleId) {

		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, employee, staffCategoryId, genderId, departmentId, regionId, adgId, zoneId, circleId, divisionId, employeeGroupId, designationId, reservationClasificationId, postHeldId, cadreId, specialisationId, stationId, employeeStatusId, payScaleId);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.OK);
	}

	// Get Employee By Id
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") int employeeId) {
		EmployeeDto getEmployee = employeeService.getEmployee(employeeId);
		return new ResponseEntity<EmployeeDto>(getEmployee, HttpStatus.OK);
	}

	// Get All Employee

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		List<EmployeeDto> employeeList = employeeService.employeeList();
		return new ResponseEntity<List<EmployeeDto>>(employeeList, HttpStatus.OK);
	}

	// Delete Employee
	@DeleteMapping("/delete/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}

}

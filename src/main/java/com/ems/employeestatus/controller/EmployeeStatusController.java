package com.ems.employeestatus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.employeestatus.payload.EmployeeStatusDto;
import com.ems.employeestatus.service.EmployeeStatusService;

@RestController
@RequestMapping("/employeeStatus")
public class EmployeeStatusController {
	private EmployeeStatusService employeeStatusService;

	public EmployeeStatusController(EmployeeStatusService employeeStatusService) {
		this.employeeStatusService = employeeStatusService;
	}

	// Create EmployeeStatus

	@PostMapping("/create")
	public ResponseEntity<EmployeeStatusDto> createEmployeeStatus(@RequestBody EmployeeStatusDto employeeStatus) {
		EmployeeStatusDto createEmployeeStatus = employeeStatusService.createEmployeeStatus(employeeStatus);

		return new ResponseEntity<EmployeeStatusDto>(createEmployeeStatus, HttpStatus.CREATED);
	}

	// Update EmployeeStatus

	@PutMapping("/update/{employeeStatusId}")
	public ResponseEntity<EmployeeStatusDto> updateEmployeeStatus(
			@PathVariable("employeeStatusId") int employeeStatusId, @RequestBody EmployeeStatusDto employeeStatus) {
		EmployeeStatusDto updateEmployeeStatus = employeeStatusService.updateEmployeeStatus(employeeStatusId,
				employeeStatus);
		return new ResponseEntity<EmployeeStatusDto>(updateEmployeeStatus, HttpStatus.OK);
	}

	// Get EmployeeStatus By Id

	@GetMapping("/{employeeStatusId}")
	public ResponseEntity<EmployeeStatusDto> getEmployeeStatusById(
			@PathVariable("employeeStatusId") int employeeStatusId) {
		EmployeeStatusDto getEmployeeStatus = employeeStatusService.getEmployeeStatus(employeeStatusId);
		return new ResponseEntity<EmployeeStatusDto>(getEmployeeStatus, HttpStatus.OK);
	}

	// Get All EmployeeStatus

	@GetMapping("/")
	public ResponseEntity<List<EmployeeStatusDto>> getAllEmployeeStatus() {
		List<EmployeeStatusDto> employeeStatusList = employeeStatusService.employeeStatusList();
		return new ResponseEntity<List<EmployeeStatusDto>>(employeeStatusList, HttpStatus.OK);
	}

	// Delete EmployeeStatus

	@DeleteMapping("/{employeeStatusId}")
	public void deleteEmployeeStatus(@PathVariable("employeeStatusId") int employeeStatusId) {
		employeeStatusService.deleteEmployeeStatus(employeeStatusId);
	}
}

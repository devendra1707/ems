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

import com.ems.employeestatus.model.EmployeeStatus;
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
	public ResponseEntity<EmployeeStatus> createEmployeeStatus(@RequestBody EmployeeStatus employeeStatus) {
		EmployeeStatus createEmployeeStatus = employeeStatusService.createEmployeeStatus(employeeStatus);

		return new ResponseEntity<EmployeeStatus>(createEmployeeStatus, HttpStatus.CREATED);
	}

	// Update EmployeeStatus

	@PutMapping("/update/{employeeStatusId}")
	public ResponseEntity<EmployeeStatus> updateEmployeeStatus(@PathVariable("employeeStatusId") int employeeStatusId,
			@RequestBody EmployeeStatus employeeStatus) {
		EmployeeStatus updateEmployeeStatus = employeeStatusService.updateEmployeeStatus(employeeStatusId,
				employeeStatus);
		return new ResponseEntity<EmployeeStatus>(updateEmployeeStatus, HttpStatus.OK);
	}

	// Get EmployeeStatus By Id

	@GetMapping("/{employeeStatusId}")
	public ResponseEntity<EmployeeStatus> getEmployeeStatusById(
			@PathVariable("employeeStatusId") int employeeStatusId) {
		EmployeeStatus getEmployeeStatus = employeeStatusService.getEmployeeStatus(employeeStatusId);
		return new ResponseEntity<EmployeeStatus>(getEmployeeStatus, HttpStatus.OK);
	}

	// Get All EmployeeStatus

	@GetMapping("/")
	public ResponseEntity<List<EmployeeStatus>> getAllEmployeeStatus() {
		List<EmployeeStatus> employeeStatusList = employeeStatusService.employeeStatusList();
		return new ResponseEntity<List<EmployeeStatus>>(employeeStatusList, HttpStatus.OK);
	}

	// Delete EmployeeStatus

	@DeleteMapping("/{employeeStatusId}")
	public void deleteEmployeeStatus(@PathVariable("employeeStatusId") int employeeStatusId) {
		employeeStatusService.deleteEmployeeStatus(employeeStatusId);
	}
}

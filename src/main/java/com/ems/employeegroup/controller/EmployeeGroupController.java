package com.ems.employeegroup.controller;

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

import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeegroup.service.EmployeeGroupService;

@RestController
@RequestMapping("/employeeGroup")
public class EmployeeGroupController {
	private EmployeeGroupService employeeGroupService;

	public EmployeeGroupController(EmployeeGroupService employeeGroupService) {
		this.employeeGroupService = employeeGroupService;
	}

	// Create EmployeeGroup

	@PostMapping("/create")
	public ResponseEntity<EmployeeGroup> createEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		EmployeeGroup createEmployeeGroup = employeeGroupService.createEmployeeGroup(employeeGroup);

		return new ResponseEntity<EmployeeGroup>(createEmployeeGroup, HttpStatus.CREATED);
	}

	// Update EmployeeGroup

	@PutMapping("/update/{employeeGroupId}")
	public ResponseEntity<EmployeeGroup> updateEmployeeGroup(@PathVariable("employeeGroupId") int employeeGroupId,
			@RequestBody EmployeeGroup employeeGroup) {
		EmployeeGroup updateEmployeeGroup = employeeGroupService.updateEmployeeGroup(employeeGroupId, employeeGroup);
		return new ResponseEntity<EmployeeGroup>(updateEmployeeGroup, HttpStatus.OK);
	}

	// Get EmployeeGroup By Id

	@GetMapping("/{employeeGroupId}")
	public ResponseEntity<EmployeeGroup> getEmployeeGroupById(@PathVariable("employeeGroupId") int employeeGroupId) {
		EmployeeGroup getEmployeeGroup = employeeGroupService.getEmployeeGroup(employeeGroupId);
		return new ResponseEntity<EmployeeGroup>(getEmployeeGroup, HttpStatus.OK);
	}

	// Get All EmployeeGroup

	@GetMapping("/")
	public ResponseEntity<List<EmployeeGroup>> getAllEmployeeGroup() {
		List<EmployeeGroup> employeeGroupList = employeeGroupService.employeeGroupList();
		return new ResponseEntity<List<EmployeeGroup>>(employeeGroupList, HttpStatus.OK);
	}

	// Delete EmployeeGroup

	@DeleteMapping("/{employeeGroupId}")
	public void deleteEmployeeGroup(@PathVariable("employeeGroupId") int employeeGroupId) {
		employeeGroupService.deleteEmployeeGroup(employeeGroupId);
	}
}

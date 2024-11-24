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

import com.ems.employeegroup.payload.EmployeeGroupDto;
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
	public ResponseEntity<EmployeeGroupDto> createEmployeeGroup(@RequestBody EmployeeGroupDto employeeGroup) {
		EmployeeGroupDto createEmployeeGroup = employeeGroupService.createEmployeeGroup(employeeGroup);

		return new ResponseEntity<EmployeeGroupDto>(createEmployeeGroup, HttpStatus.CREATED);
	}

	// Update EmployeeGroup

	@PutMapping("/update/{employeeGroupId}")
	public ResponseEntity<EmployeeGroupDto> updateEmployeeGroup(@PathVariable("employeeGroupId") int employeeGroupId,
			@RequestBody EmployeeGroupDto employeeGroup) {
		EmployeeGroupDto updateEmployeeGroup = employeeGroupService.updateEmployeeGroup(employeeGroupId, employeeGroup);
		return new ResponseEntity<EmployeeGroupDto>(updateEmployeeGroup, HttpStatus.OK);
	}

	// Get EmployeeGroup By Id

	@GetMapping("/{employeeGroupId}")
	public ResponseEntity<EmployeeGroupDto> getEmployeeGroupById(@PathVariable("employeeGroupId") int employeeGroupId) {
		EmployeeGroupDto getEmployeeGroup = employeeGroupService.getEmployeeGroup(employeeGroupId);
		return new ResponseEntity<EmployeeGroupDto>(getEmployeeGroup, HttpStatus.OK);
	}

	// Get All EmployeeGroup

	@GetMapping("/")
	public ResponseEntity<List<EmployeeGroupDto>> getAllEmployeeGroup() {
		List<EmployeeGroupDto> employeeGroupList = employeeGroupService.employeeGroupList();
		return new ResponseEntity<List<EmployeeGroupDto>>(employeeGroupList, HttpStatus.OK);
	}

	// Delete EmployeeGroup

	@DeleteMapping("/{employeeGroupId}")
	public void deleteEmployeeGroup(@PathVariable("employeeGroupId") int employeeGroupId) {
		employeeGroupService.deleteEmployeeGroup(employeeGroupId);
	}
}

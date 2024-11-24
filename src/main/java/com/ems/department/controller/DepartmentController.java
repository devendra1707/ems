package com.ems.department.controller;

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

import com.ems.department.payload.DepartmentDto;
import com.ems.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// Create Department

	@PostMapping("/create")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto department) {
		DepartmentDto createDepartment = departmentService.createDepartment(department);

		return new ResponseEntity<DepartmentDto>(createDepartment, HttpStatus.CREATED);
	}

	// Update Department

	@PutMapping("/update/{departmentId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("departmentId") int departmentId,
			@RequestBody DepartmentDto department) {
		DepartmentDto updateDepartment = departmentService.updateDepartment(departmentId, department);
		return new ResponseEntity<DepartmentDto>(updateDepartment, HttpStatus.OK);
	}

	// Get Department By Id

	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("departmentId") int departmentId) {
		DepartmentDto getDepartment = departmentService.getDepartment(departmentId);
		return new ResponseEntity<DepartmentDto>(getDepartment, HttpStatus.OK);
	}

	// Get All Department

	@GetMapping("/")
	public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
		List<DepartmentDto> departmentList = departmentService.departmentList();
		return new ResponseEntity<List<DepartmentDto>>(departmentList, HttpStatus.OK);
	}

	// Delete Department

	@DeleteMapping("/{departmentId}")
	public void deleteDepartment(@PathVariable("departmentId") int departmentId) {
		departmentService.deleteDepartment(departmentId);
	}

}

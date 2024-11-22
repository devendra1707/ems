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

import com.ems.department.model.Department;
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
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department createDepartment = departmentService.createDepartment(department);

		return new ResponseEntity<Department>(createDepartment, HttpStatus.CREATED);
	}

	// Update Department

	@PutMapping("/update/{departmentId}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") int departmentId,
			@RequestBody Department department) {
		Department updateDepartment = departmentService.updateDepartment(departmentId, department);
		return new ResponseEntity<Department>(updateDepartment, HttpStatus.OK);
	}

	// Get Department By Id

	@GetMapping("/{departmentId}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") int departmentId) {
		Department getDepartment = departmentService.getDepartment(departmentId);
		return new ResponseEntity<Department>(getDepartment, HttpStatus.OK);
	}

	// Get All Department

	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> departmentList = departmentService.departmentList();
		return new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);
	}

	// Delete Department

	@DeleteMapping("/{departmentId}")
	public void deleteDepartment(@PathVariable("departmentId") int departmentId) {
		departmentService.deleteDepartment(departmentId);
	}

}

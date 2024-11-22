package com.ems.staffcategory.controller;

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

import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.service.StaffCategoryService;

@RestController
@RequestMapping("/staffCategory")
public class StaffCategoryController {
	private StaffCategoryService staffCategoryService;

	public StaffCategoryController(StaffCategoryService staffCategoryService) {
		this.staffCategoryService = staffCategoryService;
	}

	// Create StaffCategory

	@PostMapping("/create")
	public ResponseEntity<StaffCategory> createStaffCategory(@RequestBody StaffCategory staffCategory) {
		StaffCategory createStaffCategory = staffCategoryService.createStaffCategory(staffCategory);

		return new ResponseEntity<StaffCategory>(createStaffCategory, HttpStatus.CREATED);
	}

	// Update StaffCategory

	@PutMapping("/update/{staffCategoryId}")
	public ResponseEntity<StaffCategory> updateStaffCategory(@PathVariable("staffCategoryId") int staffCategoryId,
			@RequestBody StaffCategory staffCategory) {
		StaffCategory updateStaffCategory = staffCategoryService.updateStaffCategory(staffCategoryId, staffCategory);
		return new ResponseEntity<StaffCategory>(updateStaffCategory, HttpStatus.OK);
	}

	// Get StaffCategory By Id

	@GetMapping("/{staffCategoryId}")
	public ResponseEntity<StaffCategory> getStaffCategoryById(@PathVariable("staffCategoryId") int staffCategoryId) {
		StaffCategory getStaffCategory = staffCategoryService.getStaffCategory(staffCategoryId);
		return new ResponseEntity<StaffCategory>(getStaffCategory, HttpStatus.OK);
	}

	// Get All StaffCategory

	@GetMapping("/")
	public ResponseEntity<List<StaffCategory>> getAllStaffCategory() {
		List<StaffCategory> staffCategoryList = staffCategoryService.staffCategoryList();
		return new ResponseEntity<List<StaffCategory>>(staffCategoryList, HttpStatus.OK);
	}

	// Delete StaffCategory

	@DeleteMapping("/{staffCategoryId}")
	public void deleteStaffCategory(@PathVariable("staffCategoryId") int staffCategoryId) {
		staffCategoryService.deleteStaffCategory(staffCategoryId);
	}
}

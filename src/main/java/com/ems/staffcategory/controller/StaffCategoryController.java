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

import com.ems.staffcategory.payload.StaffCategoryDto;
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
	public ResponseEntity<StaffCategoryDto> createStaffCategory(@RequestBody StaffCategoryDto staffCategoryDto) {
		StaffCategoryDto createStaffCategory = staffCategoryService.createStaffCategory(staffCategoryDto);

		return new ResponseEntity<StaffCategoryDto>(createStaffCategory, HttpStatus.CREATED);
	}

	// Update StaffCategory

	@PutMapping("/update/{staffCategoryId}")
	public ResponseEntity<StaffCategoryDto> updateStaffCategory(@PathVariable("staffCategoryId") int staffCategoryId,
			@RequestBody StaffCategoryDto staffCategoryDto) {
		StaffCategoryDto updateStaffCategory = staffCategoryService.updateStaffCategory(staffCategoryId,
				staffCategoryDto);
		return new ResponseEntity<StaffCategoryDto>(updateStaffCategory, HttpStatus.OK);
	}

	// Get StaffCategory By Id

	@GetMapping("/{staffCategoryId}")
	public ResponseEntity<StaffCategoryDto> getStaffCategoryById(@PathVariable("staffCategoryId") int staffCategoryId) {
		StaffCategoryDto getStaffCategory = staffCategoryService.getStaffCategory(staffCategoryId);
		return new ResponseEntity<StaffCategoryDto>(getStaffCategory, HttpStatus.OK);
	}

	// Get All StaffCategory

	@GetMapping("/")
	public ResponseEntity<List<StaffCategoryDto>> getAllStaffCategory() {
		List<StaffCategoryDto> staffCategoryList = staffCategoryService.staffCategoryList();
		return new ResponseEntity<List<StaffCategoryDto>>(staffCategoryList, HttpStatus.OK);
	}

	// Delete StaffCategory

	@DeleteMapping("/{staffCategoryId}")
	public void deleteStaffCategory(@PathVariable("staffCategoryId") int staffCategoryId) {
		staffCategoryService.deleteStaffCategory(staffCategoryId);
	}
}

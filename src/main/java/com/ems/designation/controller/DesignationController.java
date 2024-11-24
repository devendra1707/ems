package com.ems.designation.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.designation.payload.DesignationDto;
import com.ems.designation.service.DesignationService;

@RestController
@RequestMapping("/designation")
public class DesignationController {

	private DesignationService designationService;

	public DesignationController(DesignationService designationService) {
		this.designationService = designationService;
	}

	// Create Designation

	@PostMapping("/create")
	public ResponseEntity<DesignationDto> createDesignation(@RequestBody DesignationDto designation,
			@RequestParam int staffCategoryId) {
		DesignationDto createDesignation = designationService.createDesignation(designation, staffCategoryId);

		return new ResponseEntity<DesignationDto>(createDesignation, HttpStatus.CREATED);
	}

	// Update Designation

	@PutMapping("/update/{designationId}")
	public ResponseEntity<DesignationDto> updateDesignation(@PathVariable("designationId") int designationId,
			@RequestBody DesignationDto designation, @RequestParam int staffCategoryId) {
		DesignationDto updateDesignation = designationService.updateDesignation(designationId, designation,
				staffCategoryId);
		return new ResponseEntity<DesignationDto>(updateDesignation, HttpStatus.OK);
	}

	// Get Designation By Id

	@GetMapping("/{designationId}")
	public ResponseEntity<DesignationDto> getDesignationById(@PathVariable("designationId") int designationId) {
		DesignationDto getDesignation = designationService.getDesignation(designationId);
		return new ResponseEntity<DesignationDto>(getDesignation, HttpStatus.OK);
	}

	// Get All Designation

	@GetMapping("/")
	public ResponseEntity<List<DesignationDto>> getAllDesignation() {
		List<DesignationDto> designationList = designationService.designationList();
		return new ResponseEntity<List<DesignationDto>>(designationList, HttpStatus.OK);
	}

	// Delete Designation

	@DeleteMapping("/{designationId}")
	public void deleteDesignation(@PathVariable("designationId") int designationId) {
		designationService.deleteDesignation(designationId);
	}
}

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
import org.springframework.web.bind.annotation.RestController;

import com.ems.designation.model.Designation;
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
	public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation) {
		Designation createDesignation = designationService.createDesignation(designation);

		return new ResponseEntity<Designation>(createDesignation, HttpStatus.CREATED);
	}

	// Update Designation

	@PutMapping("/update/{designationId}")
	public ResponseEntity<Designation> updateDesignation(@PathVariable("designationId") int designationId,
			@RequestBody Designation designation) {
		Designation updateDesignation = designationService.updateDesignation(designationId, designation);
		return new ResponseEntity<Designation>(updateDesignation, HttpStatus.OK);
	}

	// Get Designation By Id

	@GetMapping("/{designationId}")
	public ResponseEntity<Designation> getDesignationById(@PathVariable("designationId") int designationId) {
		Designation getDesignation = designationService.getDesignation(designationId);
		return new ResponseEntity<Designation>(getDesignation, HttpStatus.OK);
	}

	// Get All Designation

	@GetMapping("/")
	public ResponseEntity<List<Designation>> getAllDesignation() {
		List<Designation> designationList = designationService.designationList();
		return new ResponseEntity<List<Designation>>(designationList, HttpStatus.OK);
	}

	// Delete Designation

	@DeleteMapping("/{designationId}")
	public void deleteDesignation(@PathVariable("designationId") int designationId) {
		designationService.deleteDesignation(designationId);
	}
}

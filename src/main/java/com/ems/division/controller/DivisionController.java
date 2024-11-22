package com.ems.division.controller;

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

import com.ems.division.model.Division;
import com.ems.division.service.DivisionService;

@RestController
@RequestMapping("/division")
public class DivisionController {
	private DivisionService divisionService;

	public DivisionController(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	// Create ADG
	@PostMapping("/create")
	public ResponseEntity<Division> createDivision(@RequestBody Division division) {
		Division createDivision = divisionService.createDivision(division);

		return new ResponseEntity<Division>(createDivision, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{divisionId}")
	public ResponseEntity<Division> updateDivision(@PathVariable("divisionId") int divisionId,
			@RequestBody Division division) {
		Division updateDivision = divisionService.updateDivision(divisionId, division);
		return new ResponseEntity<Division>(updateDivision, HttpStatus.OK);
	}

	// Get Division By Id
	@GetMapping("/get/{divisionId}")
	public ResponseEntity<Division> getDivisionById(@PathVariable("divisionId") int divisionId) {
		Division getDivision = divisionService.getDivisionById(divisionId);
		return new ResponseEntity<Division>(getDivision, HttpStatus.OK);
	}

	// Get All Division

	@GetMapping("/all")
	public ResponseEntity<List<Division>> getAllDivision() {
		List<Division> divisionList = divisionService.divisionList();
		return new ResponseEntity<List<Division>>(divisionList, HttpStatus.OK);
	}

	// Delete Division
	@DeleteMapping("/delete/{divisionId}")
	public void deleteDivision(@PathVariable("divisionId") int divisionId) {
		divisionService.deleteDivision(divisionId);
	}
}

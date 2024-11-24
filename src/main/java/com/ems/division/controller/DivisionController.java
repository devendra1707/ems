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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.division.payload.DivisionDto;
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
	public ResponseEntity<DivisionDto> createDivision(@RequestBody DivisionDto division, @RequestParam int circleId) {
		DivisionDto createDivision = divisionService.createDivision(division, circleId);

		return new ResponseEntity<DivisionDto>(createDivision, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{divisionId}")
	public ResponseEntity<DivisionDto> updateDivision(@PathVariable("divisionId") int divisionId,
			@RequestBody DivisionDto division, @RequestParam int circleId) {
		DivisionDto updateDivision = divisionService.updateDivision(divisionId, division, circleId);
		return new ResponseEntity<DivisionDto>(updateDivision, HttpStatus.OK);
	}

	// Get Division By Id
	@GetMapping("/get/{divisionId}")
	public ResponseEntity<DivisionDto> getDivisionById(@PathVariable("divisionId") int divisionId) {
		DivisionDto getDivision = divisionService.getDivisionById(divisionId);
		return new ResponseEntity<DivisionDto>(getDivision, HttpStatus.OK);
	}

	// Get All Division

	@GetMapping("/all")
	public ResponseEntity<List<DivisionDto>> getAllDivision() {
		List<DivisionDto> divisionList = divisionService.divisionList();
		return new ResponseEntity<List<DivisionDto>>(divisionList, HttpStatus.OK);
	}

	// Delete Division
	@DeleteMapping("/delete/{divisionId}")
	public void deleteDivision(@PathVariable("divisionId") int divisionId) {
		divisionService.deleteDivision(divisionId);
	}
}

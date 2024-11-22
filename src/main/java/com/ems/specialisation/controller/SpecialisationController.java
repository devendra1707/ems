package com.ems.specialisation.controller;

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

import com.ems.specialisation.model.Specialisation;
import com.ems.specialisation.service.SpecialisationService;

@RestController
@RequestMapping("/specialisation")
public class SpecialisationController {
	private SpecialisationService specialisationService;

	public SpecialisationController(SpecialisationService specialisationService) {
		this.specialisationService = specialisationService;
	}

	// Create Specialisation

	@PostMapping("/create")
	public ResponseEntity<Specialisation> createSpecialisation(@RequestBody Specialisation specialisation) {
		Specialisation createSpecialisation = specialisationService.createSpecialisation(specialisation);

		return new ResponseEntity<Specialisation>(createSpecialisation, HttpStatus.CREATED);
	}

	// Update Specialisation

	@PutMapping("/update/{specialisationId}")
	public ResponseEntity<Specialisation> updateSpecialisation(@PathVariable("specialisationId") int specialisationId,
			@RequestBody Specialisation specialisation) {
		Specialisation updateSpecialisation = specialisationService.updateSpecialisation(specialisationId,
				specialisation);
		return new ResponseEntity<Specialisation>(updateSpecialisation, HttpStatus.OK);
	}

	// Get Specialisation By Id

	@GetMapping("/{specialisationId}")
	public ResponseEntity<Specialisation> getSpecialisationById(
			@PathVariable("specialisationId") int specialisationId) {
		Specialisation getSpecialisation = specialisationService.getSpecialisation(specialisationId);
		return new ResponseEntity<Specialisation>(getSpecialisation, HttpStatus.OK);
	}

	// Get All Specialisation

	@GetMapping("/")
	public ResponseEntity<List<Specialisation>> getAllSpecialisation() {
		List<Specialisation> specialisationList = specialisationService.specialisationList();
		return new ResponseEntity<List<Specialisation>>(specialisationList, HttpStatus.OK);
	}

	// Delete Specialisation

	@DeleteMapping("/{specialisationId}")
	public void deleteSpecialisation(@PathVariable("specialisationId") int specialisationId) {
		specialisationService.deleteSpecialisation(specialisationId);
	}
}

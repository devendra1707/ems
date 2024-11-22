package com.ems.gender.controller;

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

import com.ems.gender.model.Gender;
import com.ems.gender.service.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {

	public GenderService genderService;

	public GenderController(GenderService genderService) {
		this.genderService = genderService;
	}

	@PostMapping("/create")
	public ResponseEntity<Gender> createGender(@RequestBody Gender gender) {
		Gender saveGender = genderService.createGender(gender);
		return new ResponseEntity<Gender>(saveGender, HttpStatus.CREATED);
	}

	@PutMapping("/{genderId}")
	public ResponseEntity<Gender> updateGender(@PathVariable("genderId") int genderId, @RequestBody Gender gender) {
		Gender updateGender = genderService.updateGender(genderId, gender);
		return new ResponseEntity<Gender>(updateGender, HttpStatus.OK);
	}

	@GetMapping("/{genderId}")
	public ResponseEntity<Gender> getGender(@PathVariable("genderId") int genderId) {
		Gender getGender = genderService.getGenderById(genderId);
		return new ResponseEntity<Gender>(getGender, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Gender>> getGenderDetails() {
		Iterable<Gender> genderList = genderService.genderList();
		return new ResponseEntity<Iterable<Gender>>(genderList, HttpStatus.OK);
	}

	@DeleteMapping("/{genderId}")
	public void deleteGender(@PathVariable("genderId") int genderId) {
		genderService.deleteGender(genderId);
	}

}

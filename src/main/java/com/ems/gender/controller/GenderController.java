package com.ems.gender.controller;

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

import com.ems.gender.payload.GenderDto;
import com.ems.gender.service.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {

	public GenderService genderService;

	public GenderController(GenderService genderService) {
		this.genderService = genderService;
	}

	@PostMapping("/create")
	public ResponseEntity<GenderDto> createGender(@RequestBody GenderDto gender) {
		GenderDto saveGender = genderService.createGender(gender);
		return new ResponseEntity<GenderDto>(saveGender, HttpStatus.CREATED);
	}

	@PutMapping("/{genderId}")
	public ResponseEntity<GenderDto> updateGender(@PathVariable("genderId") int genderId,
			@RequestBody GenderDto gender) {
		GenderDto updateGender = genderService.updateGender(genderId, gender);
		return new ResponseEntity<GenderDto>(updateGender, HttpStatus.OK);
	}

	@GetMapping("/{genderId}")
	public ResponseEntity<GenderDto> getGender(@PathVariable("genderId") int genderId) {
		GenderDto getGender = genderService.getGenderById(genderId);
		return new ResponseEntity<GenderDto>(getGender, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<GenderDto>> getGenderDetails() {
		List<GenderDto> genderList = genderService.genderList();
		return new ResponseEntity<List<GenderDto>>(genderList, HttpStatus.OK);
	}

	@DeleteMapping("/{genderId}")
	public void deleteGender(@PathVariable("genderId") int genderId) {
		genderService.deleteGender(genderId);
	}

}
